/**
 * 型パラメータの名前には慣例的に T や E など、 英大文字がよく使われる。
 * T は、Type (型) の略称で、 E は Element (要素) の略称。
 * 他にも Key と Value で K と V でパラメータ、汎用的に使われるものに A , B, C という名前が使われることもある。
 */
class Cell[T](var variable: T) {
  def put(newVariable: T): Unit = {
    variable = newVariable
  }

  def get(): T = variable

  def printValue[T](cell: Cell[T]): Unit = println(cell.get())
}
/** REPL
 * scala> val cell = new Cell[Int](1)
 * val cell = new Cell[Int](1)val cell: Cell[Int] = Cell@5efe47fd
 *
 * scala> cell.put(2)
 * cell.put(2)
 * scala> cell.get()
 * cell.get()val res1: Int = 2
 *
 * scala> cell.put("something")
 * cell.put("something")
 * error: type mismatch;
 * found   : String("something")
 * required: Int
 *
 * scala> printValue(new Cell[Int](2))
 * 2
 * scala> printValue(new Cell[String]("hello"))
 * hello
 **/
