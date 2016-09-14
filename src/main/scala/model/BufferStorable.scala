package model

import java.nio.ByteBuffer
import util.primitiveBuffer.Implicits._
import util.primitiveBuffer.PrimitiveBuffer
import java.nio.Buffer

trait BufferStorable[T] {
  /** Puts this into buffer. */
  def store(e: T, buffer: PrimitiveBuffer[ByteBuffer, Byte]): PrimitiveBuffer[ByteBuffer, Byte]
}