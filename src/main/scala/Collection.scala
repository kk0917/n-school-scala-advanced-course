object Collection {
//  ...
  /**
   ***** scala> Seq > List
   * > Seq(1, 2, 3)
   * res0: Seq[Int] = List(1, 2, 3)
   *
   * > List(1, 2, 3)
   * res1: List[Int] = List(1, 2, 3)
   *
   * > Nil
   * res0: scala.collection.immutable.Nil.type = List()
   *
   * > 3::Nil
   * res1: List[Int] = List(3)
   *
   * > 2::res1
   * res2: List[Int] = List(2, 3)
   *
   * > 1::res2
   * res3: List[Int] = List(1, 2, 3)
   *
   * > 1::2::3::Nil
   * res4: List[Int] = List(1, 2, 3)
   *
   ***** scala> Seq > Array
   * > Array(1,2,3)
   * res0: Array[Int] = Array(1, 2, 3)
   *
   * > res0(1) = 4
   * res0
   * res2: Array[Int] = Array(1, 4, 3)
   *
   ***** scala> Range
   * > 1 to 5
   * res0: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5)
   *
   * > (1 to 5).toList
   * res1: List[Int] = List(1, 2, 3, 4, 5)
   *
   * > 1 until 5
   * res2: scala.collection.immutable.Range = Range(1, 2, 3, 4)
   *
   * > (1 until 5).toList
   * res3: List[Int] = List(1, 2, 3, 4)
   *
   ***** scala> StringOps
   * > val s = "aiueo"
   * s: String = aiueo
   *
   * > s(1)
   * res0: Char = i
   *
   * > s.map(c => c.toUpper)
   * res1: String = AIUEO
   *
   * > s.filter(c => c != 'u')
   * res2: String = aieo
   *
   ***** scala> Set
   * > val s1 = Set(1,2,3)
   * s1: scala.collection.immutable.Set[Int] = Set(1, 2, 3)
   *
   * > val s2 = Set(3,4,5)
   * s2: scala.collection.immutable.Set[Int] = Set(3, 4, 5)
   *
   * > s1 ++ s2
   * res0: scala.collection.immutable.Set[Int] = Set(5, 1, 2, 3, 4) // 和集合
   *
   * > s1 -- s2
   * res2: scala.collection.immutable.Set[Int] = Set(1, 2) // 差集合
   *
   * > s1.intersect(s2)
   * res2: scala.collection.immutable.Set[Int] = Set(3) // 積集合
   *
   ***** scala> HashSet
   * > scala.collection.immutable.TreeSet(1,2,3,4,5)
   * res1: scala.collection.immutable.TreeSet[Int] = TreeSet(1, 2, 3, 4, 5)
   *
   * > res1.filter(i => i != 2)
   * res2: scala.collection.immutable.TreeSet[Int] = TreeSet(1, 3, 4, 5)
   *
   ***** scala> 連想配列 Map
   * > Map("a" -> 1, "b" -> 2, "c" -> 3)
   * val m: scala.collection.immutable.Map[String,Int] = Map(a -> 1, b -> 2, c -> 3)
   *
   * > "a -> 1"
   * val res0: String = a -> 1
   *
   * > m.get("a")
   * val res1: Option[Int] = Some(1)
   *
   * > m.get("d")
   * val res2: Option[Int] = None
   *
   * > m.toList
   * val res3: List[(String, Int)] = List((a,1), (b,2), (c,3))
   *
   * > res3.toMap
   * val res4: scala.collection.immutable.Map[String,Int] = Map(a -> 1, b -> 2, c -> 3)
   *
   * > val n = scala.collection.immutable.TreeMap("a" -> 1, "b" -> 2, "c" -> 3)
   * val n: scala.collection.immutable.TreeMap[String,Int] = TreeMap(a -> 1, b -> 2, c -> 3)
   *
   * > n - "b"
   * res5: scala.collection.immutable.TreeMap[String,Int] = TreeMap(a -> 1, c -> 3)
   *
   ***** scala> Stack (last in first out)
   * > scala.collection.immutable.Stack()
   * res0: scala.collection.immutable.Stack[Nothing] = Stack()
   *
   * > res0.push(1)
   * res1: scala.collection.immutable.Stack[Int] = Stack(1)
   *
   * > res1.push(2)
   * res2: scala.collection.immutable.Stack[Int] = Stack(2, 1)
   *
   * > res2.pop2
   * res3: (Int, scala.collection.immutable.Stack[Int]) = (2,Stack(1))
   *
   * > res3._2.pop2
   * res4: (Int, scala.collection.immutable.Stack[Int]) = (1,Stack())
   *
   ***** scala> Queue
   * > scala.collection.immutable.Queue()
   * res0: scala.collection.immutable.Queue[Nothing] = Queue()
   *
   * > res0.enqueue(1)
   * res1: scala.collection.immutable.Queue[Int] = Queue(1)
   *
   * > res1.enqueue(2)
   * res2: scala.collection.immutable.Queue[Int] = Queue(1, 2)
   *
   * > res2.dequeue
   * res3: (Int, scala.collection.immutable.Queue[Int]) = (1,Queue(2))
   *
   * > res3._2.dequeue
   * res4: (Int, scala.collection.immutable.Queue[Int]) = (2,Queue()
   *
   ***** scala> PriorityQueue
   * > val q = new scala.collection.mutable.PriorityQueue[Int]
   * q: scala.collection.mutable.PriorityQueue[Int] = PriorityQueue()
   *
   * > q.enqueue(3)
   * > q.enqueue(2)
   * > q.enqueue(1)
   * > q.enqueue(7)
   * > q.enqueue(8)
   * > q.enqueue(9)
   *
   * > q.dequeue()
   * res6: Int = 9
   *
   * > q.dequeue()
   * res7: Int = 8
   *
   * > q.dequeue()
   * res8: Int = 7
   *
   * > q.dequeue()
   * res9: Int = 3
   *
   ***** Summary
   * リストは、先頭の値とその後ろのリストという形で表された再帰的な不変のデータ構造
   * 配列は、可変のデータ構造
   * 集合 Set や 連想配列 Map には可変と不変のものがある
   * 集合 Set や 連想配列 Map で順序が必要な場合には、 TreeSet と TreeMap を用いる
   * プライオリティーキューは、可変で並べ替えと先頭の値を取得するのに優れたコレクション
   * 可変コレクションと不変コレクションは、基本的には不変を用いたほうが良いが、パフォーマンスに与える影響を考慮する必要がある
   *
   ***** Question Beginner
   *
   * Evaluate List and Array Type's processing speed of Add head and Add end
   * Use this function
   *
   * def benchmark(f: => Unit) = {
   *   val begin = System.currentTimeMillis()
   *   f
   *   val end = System.currentTimeMillis()
   *   val formatter = java.text.NumberFormat.getNumberInstance()
   *   println(s"time: ${formatter.format(end - begin)} ミリ秒")
   * }
   *
   * scala> benchmark {
   * var sum = 0
   *   for(i <- 0 to 1000000){
   *     sum = sum + i
   *   }
   * }
   * time: 21 ミリ秒
   */
}