package util

import java.io.File
import org.lwjgl.opengl.GL20._
import org.lwjgl.opengl.GL11
import scala.io.Source
import scala.util.Try
import scala.util.Success
import scala.util.Failure
import model.Implicits._
import model.GlPersistentBuffer
import model.GlslType

class ShaderFactory {
  private var shaderIds = Map.empty[File, Int]
  private var shaders = Map.empty[ShaderType, File]
  private var attribLocations = Map.empty[String, ShaderArgument]
  private var uniformLocations = Map.empty[String, ShaderArgument]
  
  def setShader(shaderType: ShaderType, path: File) = {
    shaders += shaderType -> path
    this
  }
  
  def removeShader(shaderType: ShaderType) = {
    shaderIds -= shaders(shaderType)
    shaders -= shaderType
    this
  }
  
  def setAttribLocation(name: String, pos: Int, attribType: GlslType): ShaderFactory = {
    attribLocations += name -> new ShaderArgument(pos, attribType)
    this
  }
  
  def unsetAttribute(name: String): ShaderFactory = {
    attribLocations -= name
    this
  }
  
  def registerAttribute(name: String, attribType: GlslType): ShaderFactory = {
    attribLocations += name -> new ShaderArgument(ShaderFactory.UNKNOWN_LOCATION, attribType)
    this
  }
  
  def registerUniform(name: String, attribType: GlslType): ShaderFactory = {
    uniformLocations += name -> new ShaderArgument(ShaderFactory.UNKNOWN_LOCATION, attribType)
    this
  }
  
  def buildProgram(): Try[ShaderProgram] = {
    val pId = glCreateProgram()
    for(entry <- shaders) {
      if(!shaderIds.contains(entry._2)) {
        compileShader(entry._1, entry._2) match {
          case Success(id) => shaderIds += entry._2 -> id
          case Failure(e) => return Failure(e)
        }
      }
      
      val shaderId = shaderIds(entry._2)
      glAttachShader(pId, shaderId)
    }
    
    for((name, argument) <- attribLocations if(argument.location != ShaderFactory.UNKNOWN_LOCATION)) 
        glBindAttribLocation(pId, argument.location, name)
        
    glLinkProgram(pId)
    checkProgStatus(pId, GL_LINK_STATUS, "Program link")
    
    glValidateProgram(pId)
    checkProgStatus(pId, GL_VALIDATE_STATUS, "Program validation")
    
    for(id <- shaderIds.values)
      glDetachShader(pId, id)
      
    for((name, argument) <- attribLocations if(argument.location == ShaderFactory.UNKNOWN_LOCATION))
      attribLocations += name -> new ShaderArgument(glGetAttribLocation(pId, name), argument.argType)
      
    for((name, argument) <- uniformLocations if(argument.location == ShaderFactory.UNKNOWN_LOCATION))
      uniformLocations += name -> new ShaderArgument(glGetUniformLocation(pId, name), argument.argType)
      
    Success(new ShaderProgram(pId, attribLocations, uniformLocations))
  }
  
  private def compileShader(shaderType: ShaderType, shader: File): Try[Int] =
    TryWith(Source.fromFile(shader))(_.mkString) match {
      case Success(shaderSource) => {
        val shaderId = glCreateShader(shaderType)
        glShaderSource(shaderId, shaderSource)
        glCompileShader(shaderId)
        
        if(glGetShaderi(shaderId, GL_COMPILE_STATUS) == GL11.GL_FALSE)
          return Failure(new RuntimeException(s"Shader compilation error:\n${glGetShaderInfoLog(shaderId)}"))
          
        shaderIds += shader -> shaderId
        Success(shaderId)
      }
      
      case Failure(e) =>
        Failure(e)
    }
  
  private def checkProgStatus(pId: Int, statusType: Int, desc: String) = {
    if(glGetProgrami(pId, statusType) == GL11.GL_FALSE)
      throw new RuntimeException(s"${desc} error:\n${glGetProgramInfoLog(pId)}")
  }
  
  def clearShaders() = {
    shaders = Map.empty
    shaderIds = Map.empty
    this
  }
  
  def cleanUp() = {
    for(id <- shaderIds.values)
      glDeleteShader(id)
      
    this
  }
}

object ShaderFactory {
  val UNKNOWN_LOCATION = -1
}