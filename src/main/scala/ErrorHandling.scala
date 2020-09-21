object ErrorHandling {
  def divStr(target: Int, divider: Int): String = {
    (target / divider).toString
  }

  def divStrUsingNull(target: Int, divider: Int): String = {
    if (divider == 0) null else (target / divider).toString
  }

  def divStrThrowExc(target: Int, divider: Int): String = {
    if (divider == 0) throw new IllegalArgumentException("dividerに0は利用できません")
    else (target / divider).toString
  }

  def divStrUsingReqMethod(target: Int, divider: Int): String = {
    require(divider != 0, "dividerに0は利用できません。")
    (target / divider).toString
  }

  val size = try {
    divStr(10, 0)
  } catch {
    case e: IllegalArgumentException => 0
  }

  /**
   * insert some value into Option Obj
   *
   * scala> val o: Option[String] = Option("hoge")
   * val o: Option[String] = Some(hoge)
   *
   * scala> o.get
   * val res0: String = hoge
   *
   * scala> o.isEmpty
   * val res1: Boolean = false
   *
   * scala> o.isDefined
   * val res2: Boolean = true
   */

  /**
   * Insert null into Option Obj
   *
   * scala> val o: Option[String] = Option(null)
   * val o: Option[String] = Option(null)val o: Option[String] = None
   *
   * scala> o.isEmpty
   * val res0: Boolean = true
   *
   * scala> o.isDefined
   * val res1: Boolean = false
   *
   * scala> o.get
   * java.util.NoSuchElementException: None.get
   * at scala.None$.get(Option.scala:627)
   * at scala.None$.get(Option.scala:626)
   * ... 32 elided
   */

  /**
   * Use getOrElse
   *
   * scala> o.getOrElse("")
   * val res3: String = ""
   *
   * scala> o.getOrElse(throw new RuntimeException("nullは受け入れられません"))
   * java.lang.RuntimeException: nullは受け入れられません
   * at $anonfun$res4$1(<console>:1)
   * at scala.Option.getOrElse(Option.scala:201)
   * ... 32 elided
   */

  /**
   * Use patternMatch
   *
   * scala> s match {
   *   case Some(str) => println(str)
   *   case None => println("None")
   * }
   */

  /**
   * Use Option function
   *
   * scala> Some(3).map(_ * 3)
   * val res7: Option[Int] = Some(9)
   *
   * scala> n.map(_ * 3)
   * val res8: Option[Int] = None
   */

  /**
   * Use fold function
   *
   * scala> n.fold(0)(_ * 3)
   * val res9: Int = 0
   *
   * scala> Some(3).fold(0)(_ * 3)
   * val res10: Int = 9
   */

  /**
   * scala> val v1: Option[Int] = Some(3)
   * v1: Option[Int] = Some(3)
   *
   * scala> val v2: Option[Int] = Some(5)
   * v2: Option[Int] = Some(5)
   *
   * scala> v1.map(i1 => v2.map(i2 => i1 * i2))
   * res4: Option[Option[Int]] = Some(Some(15)) // Nested value
   *
   * scala> v1.map(i1 => v2.map(i2 => i1 * i2))
   * val res0: Option[Option[Int]] = Some(Some(15)) // Not Nested
   *
   * scala> v1.map(i1 => v2.map(i2 => i1 * i2)).flatten // Use flatten function
   * val res1: Option[Int] = Some(15) // Not nested
   *
   * val v3: Option[Int] = Some(7)
   * v1.flatMap(i1 => v2.flatMap(i2 => v3.map(i3 => i1 * i2 * i3))) // Use flatMap
   * val v3: Option[Int] = Some(7)val v3: Option[Int] = Some(7)
   *
   * scala> v1.flatMap(i1 => v2.flatMap(i2 => v3.map(i3 => i1 * i2 * i3)))
   * val res1: Option[Int] = Some(105)
   *
   * scala> val v4: Option[Int] = None
   * val v4: Option[Int]val v4: Option[Int] = None
   *
   * scala> v1.flatMap(i1 => v2.flatMap(i2 => v4.map(i4 => i1 * i2 * i4)))
   * val res2: Option[Int] = None
   */
}
