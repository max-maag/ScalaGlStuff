package util.primitiveBuffer

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.Buffer
import java.nio.FloatBuffer
import java.nio.IntBuffer
import java.nio.ShortBuffer
import java.nio.CharBuffer
import java.nio.DoubleBuffer
import java.nio.LongBuffer

object Implicits {
  implicit def PrimitiveBuffer2NioBuffer[P <: Buffer, B <: AnyVal](pb: PrimitiveBuffer[P, B]) = pb.underlying
  
  implicit class ByteBuffer2PrimitiveBuffer(private val b: ByteBuffer) extends PrimitiveBuffer[ByteBuffer, Byte] {
    override def array = b.array
    override def arrayOffset = b.arrayOffset
    override def asReadOnlyBuffer = b.asReadOnlyBuffer
    override def capacity = b.capacity
    override def clear() = {b.clear(); this}
    override def compact() = {b.compact(); this}
    override def compareTo(that: PrimitiveBuffer[ByteBuffer, Byte]) = b.compareTo(that.underlying)
    override def duplicate(): PrimitiveBuffer[ByteBuffer, Byte] = ByteBuffer2PrimitiveBuffer(b.duplicate())
    override def flip(): PrimitiveBuffer[ByteBuffer, Byte] = {b.flip(); this}
    override def get() = b.get()
    override def get(dst: Array[Byte]): PrimitiveBuffer[ByteBuffer, Byte] = {b.get(dst); this}
    override def get(dst: Array[Byte], offset: Int): PrimitiveBuffer[ByteBuffer, Byte] = {b.get(dst, offset); this}
    override def get(index: Int) = b.get(index)
    override def hasArray = b.hasArray
    override def hasRemaining = b.hasRemaining
    override def isDirect = b.isDirect
    override def isReadOnly = b.isReadOnly
    override def limit = b.limit
    override def limit(lim: Int): PrimitiveBuffer[ByteBuffer, Byte] = {b.limit(lim); this}
    override def mark(): PrimitiveBuffer[ByteBuffer, Byte] = {b.mark(); this}
    override def position = b.position
    override def position(pos: Int): PrimitiveBuffer[ByteBuffer, Byte] = {b.position(pos); this}
    override def order = b.order
    override def put(prim: Byte): PrimitiveBuffer[ByteBuffer, Byte] = {b.put(prim); this}
  //  override def put(primArr: Array[Byte]): PrimitiveBuffer[ByteBuffer, Byte]
    override def put(primArr: Array[Byte], offset: Int, length: Int): PrimitiveBuffer[ByteBuffer, Byte] = {b.put(primArr, offset, length); this}
    override def put(buf: ByteBuffer): PrimitiveBuffer[ByteBuffer, Byte] = {b.put(buf); this}
    override def put(pb: PrimitiveBuffer[ByteBuffer, Byte]): PrimitiveBuffer[ByteBuffer, Byte] = {b.put(pb); this}
    override def put(index: Int, prim: Byte): PrimitiveBuffer[ByteBuffer, Byte] = {b.put(index, prim); this}
    override def remaining = b.remaining
    override def reset(): PrimitiveBuffer[ByteBuffer, Byte] = {b.reset(); this}
    override def rewind(): PrimitiveBuffer[ByteBuffer, Byte] = {b.rewind(); this}
    override def slice: PrimitiveBuffer[ByteBuffer, Byte] = ByteBuffer2PrimitiveBuffer(b.slice)
    override def underlying = b
    override def wrap(primArr: Array[Byte]): PrimitiveBuffer[ByteBuffer, Byte] = {b.wrap(primArr); this}
    override def wrap(primArr: Array[Byte], offset: Int, length: Int): PrimitiveBuffer[ByteBuffer, Byte] = {b.wrap(primArr, offset, length); this}
  }
  
  implicit class FloatBuffer2PrimitiveBuffer(private val b: FloatBuffer) extends PrimitiveBuffer[FloatBuffer, Float] {
    override def array = b.array
    override def arrayOffset = b.arrayOffset
    override def asReadOnlyBuffer = b.asReadOnlyBuffer
    override def capacity = b.capacity
    override def clear() = {b.clear(); this}
    override def compact() = {b.compact(); this}
    override def compareTo(that: PrimitiveBuffer[FloatBuffer, Float]) = b.compareTo(that.underlying)
    override def duplicate(): PrimitiveBuffer[FloatBuffer, Float] = FloatBuffer2PrimitiveBuffer(b.duplicate())
    override def flip(): PrimitiveBuffer[FloatBuffer, Float] = {b.flip(); this}
    override def get() = b.get()
    override def get(dst: Array[Float]): PrimitiveBuffer[FloatBuffer, Float] = {b.get(dst); this}
    override def get(dst: Array[Float], offset: Int): PrimitiveBuffer[FloatBuffer, Float] = {b.get(dst, offset); this}
    override def get(index: Int) = b.get(index)
    override def hasArray = b.hasArray
    override def hasRemaining = b.hasRemaining
    override def isDirect = b.isDirect
    override def isReadOnly = b.isReadOnly
    override def limit = b.limit
    override def limit(lim: Int): PrimitiveBuffer[FloatBuffer, Float] = {b.limit(lim); this}
    override def mark(): PrimitiveBuffer[FloatBuffer, Float] = {b.mark(); this}
    override def position = b.position
    override def position(pos: Int): PrimitiveBuffer[FloatBuffer, Float] = {b.position(pos); this}
    override def order = b.order
    override def put(prim: Float): PrimitiveBuffer[FloatBuffer, Float] = {b.put(prim); this}
  //  override def put(primArr: Array[Float]): PrimitiveBuffer[FloatBuffer, Float]
    override def put(primArr: Array[Float], offset: Int, length: Int): PrimitiveBuffer[FloatBuffer, Float] = {b.put(primArr, offset, length); this}
    override def put(buf: FloatBuffer): PrimitiveBuffer[FloatBuffer, Float] = {b.put(buf); this}
    override def put(pb: PrimitiveBuffer[FloatBuffer, Float]): PrimitiveBuffer[FloatBuffer, Float] = {b.put(pb); this}
    override def put(index: Int, prim: Float): PrimitiveBuffer[FloatBuffer, Float] = {b.put(index, prim); this}
    override def remaining = b.remaining
    override def reset(): PrimitiveBuffer[FloatBuffer, Float] = {b.reset(); this}
    override def rewind(): PrimitiveBuffer[FloatBuffer, Float] = {b.rewind(); this}
    override def slice: PrimitiveBuffer[FloatBuffer, Float] = FloatBuffer2PrimitiveBuffer(b.slice)
    override def underlying = b
    override def wrap(primArr: Array[Float]): PrimitiveBuffer[FloatBuffer, Float] = {b.wrap(primArr); this}
    override def wrap(primArr: Array[Float], offset: Int, length: Int): PrimitiveBuffer[FloatBuffer, Float] = {b.wrap(primArr, offset, length); this}
  }
  
  implicit class IntBuffer2PrimitiveBuffer(private val b: IntBuffer) extends PrimitiveBuffer[IntBuffer, Int] {
    override def array = b.array
    override def arrayOffset = b.arrayOffset
    override def asReadOnlyBuffer = b.asReadOnlyBuffer
    override def capacity = b.capacity
    override def clear() = {b.clear(); this}
    override def compact() = {b.compact(); this}
    override def compareTo(that: PrimitiveBuffer[IntBuffer, Int]) = b.compareTo(that.underlying)
    override def duplicate(): PrimitiveBuffer[IntBuffer, Int] = IntBuffer2PrimitiveBuffer(b.duplicate())
    override def flip(): PrimitiveBuffer[IntBuffer, Int] = {b.flip(); this}
    override def get() = b.get()
    override def get(dst: Array[Int]): PrimitiveBuffer[IntBuffer, Int] = {b.get(dst); this}
    override def get(dst: Array[Int], offset: Int): PrimitiveBuffer[IntBuffer, Int] = {b.get(dst, offset); this}
    override def get(index: Int) = b.get(index)
    override def hasArray = b.hasArray
    override def hasRemaining = b.hasRemaining
    override def isDirect = b.isDirect
    override def isReadOnly = b.isReadOnly
    override def limit = b.limit
    override def limit(lim: Int): PrimitiveBuffer[IntBuffer, Int] = {b.limit(lim); this}
    override def mark(): PrimitiveBuffer[IntBuffer, Int] = {b.mark(); this}
    override def position = b.position
    override def position(pos: Int): PrimitiveBuffer[IntBuffer, Int] = {b.position(pos); this}
    override def order = b.order
    override def put(prim: Int): PrimitiveBuffer[IntBuffer, Int] = {b.put(prim); this}
  //  override def put(primArr: Array[Int]): PrimitiveBuffer[IntBuffer, Int]
    override def put(primArr: Array[Int], offset: Int, length: Int): PrimitiveBuffer[IntBuffer, Int] = {b.put(primArr, offset, length); this}
    override def put(buf: IntBuffer): PrimitiveBuffer[IntBuffer, Int] = {b.put(buf); this}
    override def put(pb: PrimitiveBuffer[IntBuffer, Int]): PrimitiveBuffer[IntBuffer, Int] = {b.put(pb); this}
    override def put(index: Int, prim: Int): PrimitiveBuffer[IntBuffer, Int] = {b.put(index, prim); this}
    override def remaining = b.remaining
    override def reset(): PrimitiveBuffer[IntBuffer, Int] = {b.reset(); this}
    override def rewind(): PrimitiveBuffer[IntBuffer, Int] = {b.rewind(); this}
    override def slice: PrimitiveBuffer[IntBuffer, Int] = IntBuffer2PrimitiveBuffer(b.slice)
    override def underlying = b
    override def wrap(primArr: Array[Int]): PrimitiveBuffer[IntBuffer, Int] = {b.wrap(primArr); this}
    override def wrap(primArr: Array[Int], offset: Int, length: Int): PrimitiveBuffer[IntBuffer, Int] = {b.wrap(primArr, offset, length); this}
  }
  
  implicit class LongBuffer2PrimitiveBuffer(private val b: LongBuffer) extends PrimitiveBuffer[LongBuffer, Long] {
    override def array = b.array
    override def arrayOffset = b.arrayOffset
    override def asReadOnlyBuffer = b.asReadOnlyBuffer
    override def capacity = b.capacity
    override def clear() = {b.clear(); this}
    override def compact() = {b.compact(); this}
    override def compareTo(that: PrimitiveBuffer[LongBuffer, Long]) = b.compareTo(that.underlying)
    override def duplicate(): PrimitiveBuffer[LongBuffer, Long] = LongBuffer2PrimitiveBuffer(b.duplicate())
    override def flip(): PrimitiveBuffer[LongBuffer, Long] = {b.flip(); this}
    override def get() = b.get()
    override def get(dst: Array[Long]): PrimitiveBuffer[LongBuffer, Long] = {b.get(dst); this}
    override def get(dst: Array[Long], offset: Int): PrimitiveBuffer[LongBuffer, Long] = {b.get(dst, offset); this}
    override def get(index: Int) = b.get(index)
    override def hasArray = b.hasArray
    override def hasRemaining = b.hasRemaining
    override def isDirect = b.isDirect
    override def isReadOnly = b.isReadOnly
    override def limit = b.limit
    override def limit(lim: Int): PrimitiveBuffer[LongBuffer, Long] = {b.limit(lim); this}
    override def mark(): PrimitiveBuffer[LongBuffer, Long] = {b.mark(); this}
    override def position = b.position
    override def position(pos: Int): PrimitiveBuffer[LongBuffer, Long] = {b.position(pos); this}
    override def order = b.order
    override def put(prim: Long): PrimitiveBuffer[LongBuffer, Long] = {b.put(prim); this}
  //  override def put(primArr: Array[Long]): PrimitiveBuffer[LongBuffer, Long]
    override def put(primArr: Array[Long], offset: Int, length: Int): PrimitiveBuffer[LongBuffer, Long] = {b.put(primArr, offset, length); this}
    override def put(buf: LongBuffer): PrimitiveBuffer[LongBuffer, Long] = {b.put(buf); this}
    override def put(pb: PrimitiveBuffer[LongBuffer, Long]): PrimitiveBuffer[LongBuffer, Long] = {b.put(pb); this}
    override def put(index: Int, prim: Long): PrimitiveBuffer[LongBuffer, Long] = {b.put(index, prim); this}
    override def remaining = b.remaining
    override def reset(): PrimitiveBuffer[LongBuffer, Long] = {b.reset(); this}
    override def rewind(): PrimitiveBuffer[LongBuffer, Long] = {b.rewind(); this}
    override def slice: PrimitiveBuffer[LongBuffer, Long] = LongBuffer2PrimitiveBuffer(b.slice)
    override def underlying = b
    override def wrap(primArr: Array[Long]): PrimitiveBuffer[LongBuffer, Long] = {b.wrap(primArr); this}
    override def wrap(primArr: Array[Long], offset: Int, length: Int): PrimitiveBuffer[LongBuffer, Long] = {b.wrap(primArr, offset, length); this}
  }
  
  implicit class DoubleBuffer2PrimitiveBuffer(private val b: DoubleBuffer) extends PrimitiveBuffer[DoubleBuffer, Double] {
    override def array = b.array
    override def arrayOffset = b.arrayOffset
    override def asReadOnlyBuffer = b.asReadOnlyBuffer
    override def capacity = b.capacity
    override def clear() = {b.clear(); this}
    override def compact() = {b.compact(); this}
    override def compareTo(that: PrimitiveBuffer[DoubleBuffer, Double]) = b.compareTo(that.underlying)
    override def duplicate(): PrimitiveBuffer[DoubleBuffer, Double] = DoubleBuffer2PrimitiveBuffer(b.duplicate())
    override def flip(): PrimitiveBuffer[DoubleBuffer, Double] = {b.flip(); this}
    override def get() = b.get()
    override def get(dst: Array[Double]): PrimitiveBuffer[DoubleBuffer, Double] = {b.get(dst); this}
    override def get(dst: Array[Double], offset: Int): PrimitiveBuffer[DoubleBuffer, Double] = {b.get(dst, offset); this}
    override def get(index: Int) = b.get(index)
    override def hasArray = b.hasArray
    override def hasRemaining = b.hasRemaining
    override def isDirect = b.isDirect
    override def isReadOnly = b.isReadOnly
    override def limit = b.limit
    override def limit(lim: Int): PrimitiveBuffer[DoubleBuffer, Double] = {b.limit(lim); this}
    override def mark(): PrimitiveBuffer[DoubleBuffer, Double] = {b.mark(); this}
    override def position = b.position
    override def position(pos: Int): PrimitiveBuffer[DoubleBuffer, Double] = {b.position(pos); this}
    override def order = b.order
    override def put(prim: Double): PrimitiveBuffer[DoubleBuffer, Double] = {b.put(prim); this}
  //  override def put(primArr: Array[Double]): PrimitiveBuffer[DoubleBuffer, Double]
    override def put(primArr: Array[Double], offset: Int, length: Int): PrimitiveBuffer[DoubleBuffer, Double] = {b.put(primArr, offset, length); this}
    override def put(buf: DoubleBuffer): PrimitiveBuffer[DoubleBuffer, Double] = {b.put(buf); this}
    override def put(pb: PrimitiveBuffer[DoubleBuffer, Double]): PrimitiveBuffer[DoubleBuffer, Double] = {b.put(pb); this}
    override def put(index: Int, prim: Double): PrimitiveBuffer[DoubleBuffer, Double] = {b.put(index, prim); this}
    override def remaining = b.remaining
    override def reset(): PrimitiveBuffer[DoubleBuffer, Double] = {b.reset(); this}
    override def rewind(): PrimitiveBuffer[DoubleBuffer, Double] = {b.rewind(); this}
    override def slice: PrimitiveBuffer[DoubleBuffer, Double] = DoubleBuffer2PrimitiveBuffer(b.slice)
    override def underlying = b
    override def wrap(primArr: Array[Double]): PrimitiveBuffer[DoubleBuffer, Double] = {b.wrap(primArr); this}
    override def wrap(primArr: Array[Double], offset: Int, length: Int): PrimitiveBuffer[DoubleBuffer, Double] = {b.wrap(primArr, offset, length); this}
  }
  
  implicit class CharBuffer2PrimitiveBuffer(private val b: CharBuffer) extends PrimitiveBuffer[CharBuffer, Char] {
    override def array = b.array
    override def arrayOffset = b.arrayOffset
    override def asReadOnlyBuffer = b.asReadOnlyBuffer
    override def capacity = b.capacity
    override def clear() = {b.clear(); this}
    override def compact() = {b.compact(); this}
    override def compareTo(that: PrimitiveBuffer[CharBuffer, Char]) = b.compareTo(that.underlying)
    override def duplicate(): PrimitiveBuffer[CharBuffer, Char] = CharBuffer2PrimitiveBuffer(b.duplicate())
    override def flip(): PrimitiveBuffer[CharBuffer, Char] = {b.flip(); this}
    override def get() = b.get()
    override def get(dst: Array[Char]): PrimitiveBuffer[CharBuffer, Char] = {b.get(dst); this}
    override def get(dst: Array[Char], offset: Int): PrimitiveBuffer[CharBuffer, Char] = {b.get(dst, offset); this}
    override def get(index: Int) = b.get(index)
    override def hasArray = b.hasArray
    override def hasRemaining = b.hasRemaining
    override def isDirect = b.isDirect
    override def isReadOnly = b.isReadOnly
    override def limit = b.limit
    override def limit(lim: Int): PrimitiveBuffer[CharBuffer, Char] = {b.limit(lim); this}
    override def mark(): PrimitiveBuffer[CharBuffer, Char] = {b.mark(); this}
    override def position = b.position
    override def position(pos: Int): PrimitiveBuffer[CharBuffer, Char] = {b.position(pos); this}
    override def order = b.order
    override def put(prim: Char): PrimitiveBuffer[CharBuffer, Char] = {b.put(prim); this}
  //  override def put(primArr: Array[Char]): PrimitiveBuffer[CharBuffer, Char]
    override def put(primArr: Array[Char], offset: Int, length: Int): PrimitiveBuffer[CharBuffer, Char] = {b.put(primArr, offset, length); this}
    override def put(buf: CharBuffer): PrimitiveBuffer[CharBuffer, Char] = {b.put(buf); this}
    override def put(pb: PrimitiveBuffer[CharBuffer, Char]): PrimitiveBuffer[CharBuffer, Char] = {b.put(pb); this}
    override def put(index: Int, prim: Char): PrimitiveBuffer[CharBuffer, Char] = {b.put(index, prim); this}
    override def remaining = b.remaining
    override def reset(): PrimitiveBuffer[CharBuffer, Char] = {b.reset(); this}
    override def rewind(): PrimitiveBuffer[CharBuffer, Char] = {b.rewind(); this}
    override def slice: PrimitiveBuffer[CharBuffer, Char] = CharBuffer2PrimitiveBuffer(b.slice)
    override def underlying = b
    override def wrap(primArr: Array[Char]): PrimitiveBuffer[CharBuffer, Char] = {b.wrap(primArr); this}
    override def wrap(primArr: Array[Char], offset: Int, length: Int): PrimitiveBuffer[CharBuffer, Char] = {b.wrap(primArr, offset, length); this}
  }
  
  implicit class ShortBuffer2PrimitiveBuffer(private val b: ShortBuffer) extends PrimitiveBuffer[ShortBuffer, Short] {
    override def array = b.array
    override def arrayOffset = b.arrayOffset
    override def asReadOnlyBuffer = b.asReadOnlyBuffer
    override def capacity = b.capacity
    override def clear() = {b.clear(); this}
    override def compact() = {b.compact(); this}
    override def compareTo(that: PrimitiveBuffer[ShortBuffer, Short]) = b.compareTo(that.underlying)
    override def duplicate(): PrimitiveBuffer[ShortBuffer, Short] = ShortBuffer2PrimitiveBuffer(b.duplicate())
    override def flip(): PrimitiveBuffer[ShortBuffer, Short] = {b.flip(); this}
    override def get() = b.get()
    override def get(dst: Array[Short]): PrimitiveBuffer[ShortBuffer, Short] = {b.get(dst); this}
    override def get(dst: Array[Short], offset: Int): PrimitiveBuffer[ShortBuffer, Short] = {b.get(dst, offset); this}
    override def get(index: Int) = b.get(index)
    override def hasArray = b.hasArray
    override def hasRemaining = b.hasRemaining
    override def isDirect = b.isDirect
    override def isReadOnly = b.isReadOnly
    override def limit = b.limit
    override def limit(lim: Int): PrimitiveBuffer[ShortBuffer, Short] = {b.limit(lim); this}
    override def mark(): PrimitiveBuffer[ShortBuffer, Short] = {b.mark(); this}
    override def position = b.position
    override def position(pos: Int): PrimitiveBuffer[ShortBuffer, Short] = {b.position(pos); this}
    override def order = b.order
    override def put(prim: Short): PrimitiveBuffer[ShortBuffer, Short] = {b.put(prim); this}
  //  override def put(primArr: Array[Short]): PrimitiveBuffer[ShortBuffer, Short]
    override def put(primArr: Array[Short], offset: Int, length: Int): PrimitiveBuffer[ShortBuffer, Short] = {b.put(primArr, offset, length); this}
    override def put(buf: ShortBuffer): PrimitiveBuffer[ShortBuffer, Short] = {b.put(buf); this}
    override def put(pb: PrimitiveBuffer[ShortBuffer, Short]): PrimitiveBuffer[ShortBuffer, Short] = {b.put(pb); this}
    override def put(index: Int, prim: Short): PrimitiveBuffer[ShortBuffer, Short] = {b.put(index, prim); this}
    override def remaining = b.remaining
    override def reset(): PrimitiveBuffer[ShortBuffer, Short] = {b.reset(); this}
    override def rewind(): PrimitiveBuffer[ShortBuffer, Short] = {b.rewind(); this}
    override def slice: PrimitiveBuffer[ShortBuffer, Short] = ShortBuffer2PrimitiveBuffer(b.slice)
    override def underlying = b
    override def wrap(primArr: Array[Short]): PrimitiveBuffer[ShortBuffer, Short] = {b.wrap(primArr); this}
    override def wrap(primArr: Array[Short], offset: Int, length: Int): PrimitiveBuffer[ShortBuffer, Short] = {b.wrap(primArr, offset, length); this}
  }
}