object XMLLiteral {
  /**
   * scala>
   * <videos>
   *  <video id="1"><title>動画1</title></video>
   *  <video id="2"><title>動画2</title></video>
   * </videos>
   * res0: scala.xml.Elem =
   * <videos>
   *  <video id="1"><title>動画1</title></video>
   *  <video id="2"><title>動画2</title></video>
   * </videos>
   *
   * scala> res0.toString
   * res1: String =
   * <videos>
   *  <video id="1"><title>動画1</title></video>
   *  <video id="2"><title>動画2</title></video>
   * </videos>
   *
   * scala> res0 \ "video"
   * res2: scala.xml.NodeSeq = NodeSeq(<video id="1"><title>動画1</title></video>, <video id="2"><title>動画2</title></video>)
   *
   * scala> res0 \ "title"
   * res3: scala.xml.NodeSeq = NodeSeq()
   *
   * scala> res0 \\ "title"
   * res4: scala.xml.NodeSeq = NodeSeq(<title>動画1</title>, <title>動画2</title>)
   *
   * scala> (res0 \\ "title").map(_.text)
   * res5: scala.collection.immutable.Seq[String] = List(動画1, 動画2)
   */
}
