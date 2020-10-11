object Stream {
  /**
   ***** scala> Stream
   *
   * scala> val s = 1 #:: 2 #:: 3 #:: 4 #:: Stream.empty
   * s: scala.collection.immutable.Stream[Int] = Stream(1, ?)
   *
   * s(0)
   * res0: Int = 1
   *
   * > s(1)
   * res1: Int = 2
   *
   * > s(2)
   * res2: Int = 3
   *
   * > s.toList
   * res3: List[Int] = List(1, 2, 3, 4)
   *
   ***** scala> Infinite Stream
   *
   * > val eights: Stream[Int] = 8 #:: eights
   * eights: Stream[Int] = Stream(8, ?)
   *
   * > eights(100)
   * res4: Int = 8
   *
   * > eights(10000)
   * res5: Int = 8 // infinite stream
   *
   * > eights.take(10).toList
   * val res0: List[Int] = List(8, 8, 8, 8, 8, 8, 8, 8, 8, 8)
   *
   * > eights.toList
   * // infinite roop...
   *
   ***** scala> Recursive function
   *
   * > val s = Stream.iterate(1) {
   *   n =>
   *   println("Calcurate! 3 + " + n)
   *   3 + n
   * }
   * val s: scala.collection.immutable.Stream[Int] = Stream(1, <not computed>)
   *
   * > s(0)
   * val res0: Int = 1
   *
   * > s(1)
   * Calcurate! 3 + 1
   * res1: Int = 4
   *
   * > s(2)
   * Calcurate! 3 + 4
   * val res2: Int = 7
   *
   * s(10)
   * s(10)Calcurate! 3 7
   * Calcurate! 3 10
   * Calcurate! 3 13
   * Calcurate! 3 16
   * Calcurate! 3 19
   * Calcurate! 3 22
   * Calcurate! 3 25
   * Calcurate! 3 28
   * val res3: Int = 31
   *
   * > s(10)
   * s(10)val res4: Int = 31 // The previous value is retained
   *
   *** Scala> lazy
   * lazy val reuse previous value when it was evaluated
   *
   * > lazy val ten = {
   * println("Calcutate! ten")
   * 2 * 5
   * }
   * lazy val ten: Int // unevaluated
   *
   * > ten
   * Calcutate! ten
   * val res5: Int = 10
   *
   * > ten
   * val res6: Int = 10
   *
   * > val fibs: Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }
   * val fibs: Stream[Int] = Stream(0, <not computed>)
   *
   * > List(1,2,3).zip(List(10,20,30)) // enable merge several each Stream and List
   * val res7: List[(Int, Int)] = List((1,10), (2,20), (3,30))
   *
   * def benchmark[T](f: => T) = {
   *   val begin = System.currentTimeMillis()
   *   val result = f
   *   val end = System.currentTimeMillis()
   *   val formatter = java.text.NumberFormat.getNumberInstance()
   *   println(s"time: ${formatter.format(end - begin)} ミリ秒")
   *   result
   * }
   *
   * > benchmark{
   *   fibs.filter(x => x % 2 == 0).map(x => x * 3).take(5).foldLeft((0))(_ + _)
   * }
   * time: 4ms
   * val res9: Int = 564
   *
   * > val list = fibs.take(1000000).toList
   * val list: List[Int] = List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ..., -1230842041...)
   *
   * > benchmark({
   *   list.filter(x => x % 2 ==0).map(x => x * 3).take(5).foldLeft(0)(_ + _)
   * })
   * time: 111ms
   * val res10: Int = 564
   *
   *** scala> Non-strict function(Stream, etc)
   *
   * > def myIf[T](condition: Boolean, ifTrue: () => T, ifFalse: () => T): T = {
   *   if(condition) ifTrue() else ifFalse()
   * }
   * myIf: [T](condition: Boolean, ifTrue: () => T, ifFalse: () => T)T
   *
   * > myIf(true, () => { println("hoge"); 1 }, () => { println("fuga"); 2 } )
   * hoge
   * res2: Int = 1
   * // 3th argument never evaluate when myIf's condition argument was given true boolean value,
   * // so unnecessary processing haven't executed.
   *
   ***** Summary
   *
   * ストリームはリストと同じようなインタフェースを持つ
   * ストリームは後に続くストリームを遅延評価することで無限の長さのコレクションを表現できる
   * ストリームは一度取得した要素の値は保持され、再計算されない
   * ストリームの値が再計算されないようにするために lazy val という変数が利用される
   * ストリームは、不要となる可能性のある処理保持したまま処理を記述できるため、処理を効率化できる
   */
}
