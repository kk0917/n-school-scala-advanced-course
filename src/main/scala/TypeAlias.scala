object TypeAlias {
  type Entry = (Int, String)
  type EntryList = List[Entry]
  /**
   * scala> val list: TypeAlias.EntryList = List(1 -> "one", 2 -> "two", 3 -> "three")
   * val list: TypeAlias.EntryList = List((1,one), (2,two), (3,three))
   */
}

class Cell[A](val content: A) {
  type ContentType = A
  // Detailed implement...
}
