object Collection {
//  ...
  /**
   *** scala> Seq > List
   * Seq(1, 2, 3)
   * res0: Seq[Int] = List(1, 2, 3)
   *
   * List(1, 2, 3)
   * res1: List[Int] = List(1, 2, 3)
   *
   * Nil
   * res0: scala.collection.immutable.Nil.type = List()
   *
   * 3::Nil
   * res1: List[Int] = List(3)
   *
   * 2::res1
   * res2: List[Int] = List(2, 3)
   *
   * 1::res2
   * res3: List[Int] = List(1, 2, 3)
   *
   * 1::2::3::Nil
   * res4: List[Int] = List(1, 2, 3)
   *
   *** scala> Seq > Array
   * Array(1,2,3)
   * res0: Array[Int] = Array(1, 2, 3)
   *
   * res0(1) = 4
   * res0
   * res2: Array[Int] = Array(1, 4, 3)
   *
   *** scala> Range
   * 1 to 5
   * res0: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5)
   *
   * (1 to 5).toList
   * res1: List[Int] = List(1, 2, 3, 4, 5)
   *
   * 1 until 5
   * res2: scala.collection.immutable.Range = Range(1, 2, 3, 4)
   *
   * (1 until 5).toList
   * res3: List[Int] = List(1, 2, 3, 4)
   *
   *** scala> StringOps
   * val s = "aiueo"
   * s: String = aiueo
   *
   * s(1)
   * res0: Char = i
   *
   * s.map(c => c.toUpper)
   * res1: String = AIUEO
   *
   * s.filter(c => c != 'u')
   * res2: String = aieo
   *
   *** scala> Set
   * val s1 = Set(1,2,3)
   * s1: scala.collection.immutable.Set[Int] = Set(1, 2, 3)
   *
   * val s2 = Set(3,4,5)
   * s2: scala.collection.immutable.Set[Int] = Set(3, 4, 5)
   *
   * s1 ++ s2
   * res0: scala.collection.immutable.Set[Int] = Set(5, 1, 2, 3, 4) // 和集合
   *
   * s1 -- s2
   * res2: scala.collection.immutable.Set[Int] = Set(1, 2) // 差集合
   *
   * s1.intersect(s2)
   * res2: scala.collection.immutable.Set[Int] = Set(3) // 積集合
   *
   *** scala> HashSet
   * scala.collection.immutable.TreeSet(1,2,3,4,5)
   * res1: scala.collection.immutable.TreeSet[Int] = TreeSet(1, 2, 3, 4, 5)
   *
   * res1.filter(i => i != 2)
   * res2: scala.collection.immutable.TreeSet[Int] = TreeSet(1, 3, 4, 5)
   */
}