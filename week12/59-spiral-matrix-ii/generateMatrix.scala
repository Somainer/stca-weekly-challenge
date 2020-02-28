object Solution {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    val board = Array.ofDim[Int](n, n)
    val g = 1.to(n * n).iterator
    val range = 0 until n
    range.zip(range.reverse).foreach { case (up, down) =>
      up to down foreach (board(up)(_) = g.next())
      (up + 1) to down foreach (board(_)(down) = g.next())
      (down - 1).to(up, -1) foreach (board(down)(_) = g.next())
      (down - 1).until(up, -1) foreach (board(_)(up) = g.next())
    }
    board
  }
}