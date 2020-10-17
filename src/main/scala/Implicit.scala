object Implicit {
  /**
   ***** scala> implicit conversions
   *
   * > import scala.language.implicitConversions
   * import scala.language.implicitConversions
   *
   *** scala> Implicit Conversion
   *
   * > implicit def intToBoolean(arg: Int): Boolean = arg != 0
   * def intToBoolean(arg: Int): Boolean
   *
   * > if (1) println("1は真なり")
   * 1は真なり
   *
   * >
   *  class RichString(val src: String) {
   *   def smile: String = src + ":-)"
   * }
   *
   * > implicit def enrichString(arg: String): RichString = new RichString(arg)
   * > "Hi, ".smile
   * val res0: String = Hi, :-)
   *
   *** scala> Convert type arg to Another type arg
   *
   * >
   * implicit  class RichString(var src: String) {
   *   def smile: String = src + ":)"
   * }
   * class RichString
   *
   * > "Hi, ".smile
   * Hi, :)
   *
   *** scala> Implicit Parameter
   * ↓ ↓ ↓
   */
}

object ImplicitParamStudy {
  class Connection {
    def executeQuery(query: String): Unit = println(s"Execute: ${query}")
  }

  def createTitle(title: String)(implicit conn: Connection): Unit = conn.executeQuery(s"create title='${title}'")

  def selectTitle(implicit conn: Connection): Unit = conn.executeQuery(s"select")

  def updateTitle(title: String)(implicit conn: Connection): Unit = conn.executeQuery(s"update title='${title}'")

  def deleteTitle(title: String)(implicit conn: Connection): Unit = conn.executeQuery(s"delete title='${title}'")

  /**
   *** scala> Type-Parameters
   *
   * implicit val connection = new ImplicitParamStudy.Connection
   * val connection: ImplicitParamStudy.Connection = ImplicitParamStudy$Connection@380ce5a3
   *
   * > ImplicitParamStudy.createTitle(("暗黙"))
   * Execute: create title='暗黙'
   *
   * > ImplicitParamStudy.selectTitle()
   * Execute: select
   *
   * > ImplicitParamStudy.updateTitle("暗黙")
   * Execute: update title='暗黙'
   *
   * > ImplicitParamStudy.deleteTitle("暗黙")
   * Execute: delete title='暗黙'
   *
   * > ImplicitParamStudy.createTitle(("暗黙"))(new ImplicitParamStudy.Connection)
   * Execute: create title='暗黙'
   *
   *** scala> implicit params to use Type class Instances
   *
   * trait Additive[A] {
   *   def plus(a: A, b: A): A
   *   def zero: A
   * }
   *
   * > def sum[A](list: List[A])(implicit m: Additive[A]): A = list.foldLeft(m.zero)((x, y) => m.plus(x, y))
   *
   * > implicit object StringAdditive extends Additive[String] {
   *   def plus(a: String, b: String): String = a + b
   *   def zero: String = ""
   * }
   *
   * > implicit object IntAdditive extends Additive[Int] {
   *   def plus(a: Int, b: Int): Int = a + b
   *   def zero: Int = 0
   * }
   *
   * > sum(List("A", "B", "C"))
   * val res4: String = ABC
   *
   * > List[Int]().sum
   * val res5: Int = 0
   *
   * > List(1,2,3,4).sum
   * val res7: Int = 10
   *
   * > List(1.1,1.2,1.3,1.4).sum
   * val res8: Double = 5.0
   */
}

object TypeClassStudy {
  trait Additive[A] {
    def plus(a: A, b: A): A

    def zero: A
  }

  case class Rational(num: Int, den: Int)

  object Rational {
    implicit object RationalAdditive extends Additive[Rational] {
      def plus(a: Rational, b: Rational): Rational = {
        if (a == zero) {
          b
        } else if (b == zero) {
          a
        } else {
          Rational(a.num * b.den + b.num * a.den, a.den * b.den)
        }
      }

      def zero: Rational = Rational(0, 0)
    }
  }

  def sum[A](list: List[A])(implicit m: Additive[A]): A = list.foldLeft(m.zero)((x, y) => m.plus(x, y))

  /*** scala> Implicit search range
   *
   * > import TypeClassStudy._
   * import TypeClassStudy._
   *
   * > sum(List(Rational(1, 1), Rational(2, 2)))
   * val res0: TypeClassStudy.Rational = Rational(4,2)
   */
}

object Summary {
  /**
   * 暗黙は強力な機能だが、可読性や保守性を考えると使う場所は考えるべき
   * 暗黙の型変換は、引数への型変換と、既存の型を拡張するために利用される
   * 暗黙引数は、よく利用される引数の省略や、型クラスのインスタンスを受け取るために利用される
   */
}
