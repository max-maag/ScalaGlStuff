package model

import org.lwjgl.opengl.GL15._
import java.nio.ByteBuffer

/**
 * Manages Manages data for the array and element buffers with persistently mapped buffers.
 * 
 * The class is thread it thread safe in the sense that multiple threads can write data simultaniously
 * without problems, however it is not checked if the underlying buffers are currently in use by OpenGL.
 * 
 * Writing to the buffers while OpenGL is reading from them, e.g. while rendering, is not allowed.
 * Make sure to glFenceSync after rendering and glClientWaitSync before writing to them.
 * 
 * elementBufferSize and arrayBufferSize are in Bytes.
 */
class ModelManager[ModelIdType](elementBufferSize: Int, arrayBufferSize: Int) {
  
  private val elementBuffer = new GlPersistentBuffer(elementBufferSize)
  private val arrayBuffer = new GlPersistentBuffer(arrayBufferSize)
  
  /**
   * vertexIndex: Index of the first vertex attribute (e.g. one vec2 is one attribute)
   * indexOffset: Index of the first element of the GL_ELEMENT_ARRAY_BUFFER
   */
  case class ModelData(vertexIndex: Int, indexIndex: Int, vertexCount: Int)
  
  private val modelMapLock = new Object
  private var modelMap = Map.empty[ModelIdType, ModelData]
  private var baseVertex = 0
  
  def putModel(id: ModelIdType, vertexData: ByteBuffer, elementData: ByteBuffer, bytesPerElement: Int = 4) = {
    // Buffers aren't thread safe. Whole copy needs to be synchronized.
    val vertexCount = elementData.remaining / bytesPerElement
    
    val vertInd = arrayBuffer.synchronized {
      arrayBuffer.buffer.put(vertexData)
      baseVertex += vertexCount
      baseVertex - vertexCount
    }
    
    val elIndex = elementBuffer.synchronized {
      val idx = elementBuffer.buffer.position
      elementBuffer.buffer.put(elementData)
      idx
    }
    
    modelMapLock.synchronized(modelMap += id -> ModelData(vertInd, elIndex/bytesPerElement, vertexCount))
  }
  
  def getModelData(id: ModelIdType) = modelMap(id)
  
  def bindBuffers() = {
    glBindBuffer(GL_ARRAY_BUFFER, arrayBuffer.id)
    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, elementBuffer.id)
  }
  
  def clear() = {
    arrayBuffer.synchronized(arrayBuffer.buffer.clear())
    elementBuffer.synchronized(elementBuffer.buffer.clear())
  }
  
  def cleanUp() = {
    elementBuffer.cleanUp()
    arrayBuffer.cleanUp()
  }
}