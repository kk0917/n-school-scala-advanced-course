object ListOperation {

  /***** List Operation
   *
   ***** scala> Merge List
   * > 1 :: 2 :: 3 :: 4 :: Nil
   * val res0: List[Int] = List(1, 2, 3, 4)
   *
   * > List(1, 2) ++ List(3, 4)
   * val res1: List[Int] = List(1, 2, 3, 4)
   *
   * > List(1) ++ List(3, 4)
   * val res2: List[Int] = List(1, 3, 4)
   *
   * > List(3,4,5) :: List(1)
   * val res3: List[Any] = List(List(3, 4, 5), 1)
   *
   * > List(1,2).++(List(3,4))
   * val res4: List[Int] = List(1, 2, 3, 4)
   *
   * > List(1,2) ::: List(3,4)
   * val res5: List[Int] = List(1, 2, 3, 4)
   *
   ***** scala> mkString
   *** mkString
   * > List(1,2,3,4,5).mkString
   * val res6: String = 12345
   *
   *** mkString(sep: String)
   * > List(1,2,3,4,5).mkString
   * val res6: String = 12345
   *
   *** mkString(start: String, sep: String, end: String)
   * > List(1,2,3,4,5).mkString("[", ",", "]")
   * val res8: String = [1,2,3,4,5]
   *
   ***** scala> foldLeft
   *** definition
   * def foldLeft[B](z: B)(f: (B, A) => B): B
   *
   * > List(2, 3, 4).foldLeft(0)((x, y) => x + y)
   * res13: Int = 9 // (0) = default value
   *
   * > List(2, 3, 4).foldLeft(1)((x, y) => x * y)
   * res14: Int = 24
   *
   * > def reverse[T](list: List[T]): List[T] = list.foldLeft(Nil: List[T])((a, b) => b :: a)
   * def reverse[T](list: List[T]): List[T]
   *
   * > reverse(List(1,2,3))
   * val res0: List[Int] = List(3, 2, 1)
   *
   ***** scala> apply .map function to element
   * > List(1,2,3,4,5).map(_ * 2)
   * val res3: List[Int] = List(2, 4, 6, 8, 10)
   *
   * > List(1,2,3,4,5).map(_ * 2)
   * List(1,2,3,4,5).map(_ * 2)val res3: List[Int] = List(2, 4, 6, 8, 10)
   *
   * > def map[T, U](list: List[T])(f: T => U): List[U] =
   *   list.foldLeft(Nil:List[U]){(x, y) => f(y) :: x}.reverse
   *
   * > map(List(1,2,3))(_ * 2)
   * val res4: List[Int] = List(2, 4, 6)
   *
   * > map(List("a", "b", "c"))(x => x + x)
   * val res5: List[String] = List(aa, bb, cc)
   *
   ***** Summary
   *
   * リストは関数型プログラミングでの処理に向く
   * mkString を利用するとリストから文字列を作成することができる
   * foldLeft や foldRight は畳み込みを行う
   * reverse や map など様々な処理を畳み込みで表現することができる
   */

}
