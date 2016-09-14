package util

import org.lwjgl.opengl.GL20._
import org.lwjgl.opengl.GL33._

class ShaderProgram(val id: Int, val attributes: Map[String, ShaderArgument], val uniforms: Map[String, ShaderArgument]) {
  def use() = glUseProgram(id)
  
  def enableVertAttribArrays() = attributes.values.foreach { argument =>
    for(i <- 0 until argument.argType.attributeSize)
      glEnableVertexAttribArray(argument.location + i)
  }
  
  def enableVertAttribArray(attrib: String) = {
    for(i <- 0 until attributes(attrib).argType.attributeSize)
      glEnableVertexAttribArray(attributes(attrib).location + i)
  }
  
  def disableVertAttribArrays() = attributes.values.foreach { argument =>
    for(i <- 0 until argument.argType.attributeSize)
      glDisableVertexAttribArray(argument.location + i)
  }
  
  def disableVertAttribArray(attrib: String) = {
    for(i <- 0 until attributes(attrib).argType.attributeSize)
      glDisableVertexAttribArray(attributes(attrib).location + i)
  }
  
  def vertexAttribDivisor(attrib: String, divisor: Int) = {
    val argument = attributes(attrib)
    for(i <- 0 until argument.argType.attributeSize)
      glVertexAttribDivisor(argument.location + i, divisor)
  }
  
  def cleanUp() = glDeleteProgram(id)
}