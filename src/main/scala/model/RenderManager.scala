package model

import org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER
import org.lwjgl.opengl.GL15.glBindBuffer
import org.lwjgl.opengl.GL32.GL_SYNC_FLUSH_COMMANDS_BIT
import org.lwjgl.opengl.GL32.GL_SYNC_GPU_COMMANDS_COMPLETE
import org.lwjgl.opengl.GL32.glClientWaitSync
import org.lwjgl.opengl.GL32.glFenceSync
import org.lwjgl.opengl.GL40.GL_DRAW_INDIRECT_BUFFER
import org.lwjgl.opengl.GL43.glMultiDrawElementsIndirect

import model.Implicits._
import util.primitiveBuffer.Implicits._
import util.RenderMode
import util.GlUtils

class RenderManager(indirectBufferSize: Long, uniformBufferSize: Long) {
  val indirectBuffer = new GlPersistentBuffer(indirectBufferSize)
  val uniformBuffer = new GlPersistentBuffer(uniformBufferSize)
  var syncObj = glFenceSync(GL_SYNC_GPU_COMMANDS_COMPLETE, 0)
  
  /**
   * Renders the GameObjects with glMultiDrawElementsIndirect.
   * 
   * Prerequisites:
   * 	1. The VAO has the correct vertex attribute pointers set and is bound.
   * 		 Don't forget to set the vertex attribute divisor for the uniform data.
   * 	2. All required models are loaded with the modelManager.
   * 
   * TODO: Use multiple sync objects and store which one reserved which memory region.
   * 			 This could enable rendering multiple frames simultaniously.
   */
  def render[ModelIdType](objects: Traversable[GameObject[ModelIdType]], modelManager: ModelManager[ModelIdType], mode: RenderMode) = {
    indirectBuffer.buffer.clear()
    uniformBuffer.buffer.clear()
    
    glClientWaitSync(syncObj, GL_SYNC_FLUSH_COMMANDS_BIT, 3000000)
    
    val objectsByModel = objects.groupBy(_.modelId)
    var ucount = 0
    for((modelId, objs) <- objectsByModel) {
      val modelData = modelManager.getModelData(modelId)
      indirectBuffer.buffer.put(modelData.vertexCount)
      indirectBuffer.buffer.put(objs.size)
      indirectBuffer.buffer.put(modelData.indexIndex)
      indirectBuffer.buffer.put(modelData.vertexIndex)
      indirectBuffer.buffer.put(ucount)
      ucount += 1
        
      for(obj <- objs) {
        uniformBuffer.buffer.put(obj.uniformData)
      }
    }
    
    glMultiDrawElementsIndirect(mode, UnsignedInt, 0, objectsByModel.size, 0)
    
    syncObj = glFenceSync(GL_SYNC_GPU_COMMANDS_COMPLETE, 0)
  }
  
  def bindBuffers() = {
    glBindBuffer(GL_ARRAY_BUFFER, uniformBuffer.id)
    glBindBuffer(GL_DRAW_INDIRECT_BUFFER, indirectBuffer.id)
  }
  
  def cleanUp() = {
    indirectBuffer.cleanUp()
    uniformBuffer.cleanUp()
  }
}