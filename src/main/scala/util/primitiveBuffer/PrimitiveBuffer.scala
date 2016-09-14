package util.primitiveBuffer

import java.nio.Buffer
import java.nio.ByteOrder

trait PrimitiveBuffer[BufferType <: Buffer, PrimitiveType <: AnyVal] {
  def array: Array[PrimitiveType]
  def arrayOffset: Int
  def asReadOnlyBuffer: PrimitiveBuffer[BufferType, PrimitiveType]
  def capacity: Int
  def clear(): PrimitiveBuffer[BufferType, PrimitiveType]
  def compact(): PrimitiveBuffer[BufferType, PrimitiveType]
  def compareTo(that: PrimitiveBuffer[BufferType, PrimitiveType]): Int
  def duplicate(): PrimitiveBuffer[BufferType, PrimitiveType]
  def flip(): PrimitiveBuffer[BufferType, PrimitiveType]
  def get(): PrimitiveType
  def get(dst: Array[PrimitiveType]): PrimitiveBuffer[BufferType, PrimitiveType]
  def get(dst: Array[PrimitiveType], offset: Int): PrimitiveBuffer[BufferType, PrimitiveType]
  def get(index: Int): PrimitiveType
  def hasArray: Boolean
  def hasRemaining: Boolean
  def isDirect: Boolean
  def isReadOnly: Boolean
  def limit: Int
  def limit(lim: Int): PrimitiveBuffer[BufferType, PrimitiveType]
  def mark(): PrimitiveBuffer[BufferType, PrimitiveType]
  def position: Int
  def position(pos: Int): PrimitiveBuffer[BufferType, PrimitiveType]
  def order: ByteOrder
  def put(prim: PrimitiveType): PrimitiveBuffer[BufferType, PrimitiveType]
//  def put(primArr: Array[PrimitiveType]): PrimitiveBuffer[BufferType, PrimitiveType]
  def put(primArr: Array[PrimitiveType], offset: Int, length: Int): PrimitiveBuffer[BufferType, PrimitiveType]
  def put(buf: BufferType): PrimitiveBuffer[BufferType, PrimitiveType]
  def put(pb: PrimitiveBuffer[BufferType, PrimitiveType]): PrimitiveBuffer[BufferType, PrimitiveType]
  def put(index: Int, prim: PrimitiveType): PrimitiveBuffer[BufferType, PrimitiveType]
  def remaining: Int
  def reset(): PrimitiveBuffer[BufferType, PrimitiveType]
  def rewind(): PrimitiveBuffer[BufferType, PrimitiveType]
  def slice: PrimitiveBuffer[BufferType, PrimitiveType]
  def underlying: BufferType
  def wrap(primArr: Array[PrimitiveType]): PrimitiveBuffer[BufferType, PrimitiveType]
  def wrap(primArr: Array[PrimitiveType], offset: Int, length: Int): PrimitiveBuffer[BufferType, PrimitiveType]
}