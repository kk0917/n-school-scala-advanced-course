import scala.annotation.tailrec

object Main {
  @tailrec
  def series(n: Int, acc: Int): Int = {
    if (n == 0) 0 else series(n - 1, acc + n)
  }

  // Begginer's Challenge
  @tailrec
  def fact(n: Int, acc: Int): Int = if (n <= 1) 1 else fact(n - 1, acc * n)
}
