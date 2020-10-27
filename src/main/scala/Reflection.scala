import scala.reflect.runtime.universe._

object Reflection {
  println("===== from class =====")
  println(typeTag[Option[_]].tpe.decls)
  /**
   * scala> Reflection
   * ===== from class =====
   * Scope{
   * def <init>: <?>;
   * final def isEmpty: <?>;
   * final def isDefined: <?>;
   * final override def knownSize: <?>;
   * def get: <?>;
   * final def getOrElse[B <: <?>](default: <?>): B;
   * final def orNull[A1 <: <?>](implicit ev: <?>): A1;
   * final def map[B <: <?>](f: <?>): Option[B];
   * final def fold[B <: <?>](ifEmpty: <?>)(f: <?>): B;
   * final def flatMap[B <: <?>](f: <?>): Option[B];
   * def flatten: <?>;
   * final def filter(p: <?>): Option[A];
   * final def filterNot(p: <?>): Option[A];
   * final def nonEmpty: <?>;
   * final def withFilter(p: <?>): Option.this.WithFilter;
   * class WithFilter extends AnyRef;
   * final def contains: <?>;
   * final def exists(p: <?>): Boolean;
   * final def forall(p: <?>): Boolean;
   * final def foreach[U <: <?>](f: <?>): Unit;
   * final def collect[B <: <?>](pf: <?>): Option[B];
   * final def orElse[B <: <?>](alternative: <?>): Option[B];
   * final def zip: <?>;
   * final def unzip: <?>;
   * final def unzip3: <?>;
   * def iterator: <?>;
   * def toList: <?>;
   */

  val list: List[Int] = List(1, 2, 3)

  def getTypeTagFromList[T: TypeTag](list: List[T]): TypeTag[T] = {
    typeTag[T]
  }

  println("========= from type parameter =========")
  println(getTypeTagFromList(list).tpe.decls)
  /**
   * ========= from type parameter =========
   * Scope{
   * def <init>: <?>;
   * def toByte: <?>;
   * def toShort: <?>;
   * def toChar: <?>;
   * def toInt: <?>;
   * def toLong: <?>;
   * def toFloat: <?>;
   * def toDouble: <?>;
   * ...
   * override def getClass(): Class[Int]
   * }
   * val res0: Reflection.type = Reflection$@45d56062
   */
}
