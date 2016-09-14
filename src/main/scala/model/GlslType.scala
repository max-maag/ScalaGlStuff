package model

import util.GlConstantWrapper
import org.lwjgl.opengl.GL11._

trait GlslType {
  val byteSize: Int
  val attributeSize: Int
}

trait Scalar extends GlslType with GlConstantWrapper {
  val attributeSize = 1
}

object GlInt extends Scalar {
  val byteSize = 4
  val oglConstant = GL_INT
}

object GlUInt extends Scalar {
  val byteSize = 4
  val oglConstant = GL_UNSIGNED_INT
}

object GlFloat extends Scalar {
  val byteSize = 4
  val oglConstant = GL_FLOAT
}

object GlDouble extends Scalar {
  val byteSize = 8
  val oglConstant = GL_DOUBLE
}

object GlBool extends Scalar {
  val byteSize = 4
  val oglConstant = GL_UNSIGNED_INT
}

class Vector(val size: Int, val scalarType: Scalar) extends GlslType {
  val attributeSize = 1
  val byteSize = size * scalarType.byteSize
}

class Matrix(val width: Int, val height: Int, val scalarType: Scalar) extends GlslType {
  def this(size: Int, scalarType: Scalar) = this(size, size, scalarType)
  val attributeSize = width
  val byteSize = width * height * scalarType.byteSize
}

class GlArray(val size: Int, val typ: GlslType) extends GlslType {
  val attributeSize = size * typ.attributeSize
  val byteSize = size * typ.byteSize
}

class Struct(val types: List[GlslType]) extends GlslType {
  // size of the struct is the sum of its parts' sizes
  val (attributeSize, byteSize) =
    types.view
      .map(t => (t.attributeSize, t.byteSize))
      .reduce((t1, t2) => (t1._1 + t2._1, t1._2 + t2._2))
}

class Sampler(val binding: Int) extends GlslType {
  val attributeSize = 1
  val byteSize = 0
}