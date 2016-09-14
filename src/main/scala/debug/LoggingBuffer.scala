package debug

import util.primitiveBuffer.Implicits._
import util.primitiveBuffer.PrimitiveBuffer
import java.nio.Buffer


class LoggingBuffer[BufferType <: Buffer, PrimitiveType <: AnyVal](val buffer: PrimitiveBuffer[BufferType, PrimitiveType]) {
  val builder = new StringBuilder
  
}