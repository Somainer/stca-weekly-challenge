object Solution {
  def solveNQueens(n: Int): List[List[String]] = {
    val buffer = collection.mutable.ListBuffer.empty[List[Int]]
    val logCache = (0 to n).map {i => (1 << i, i)}.toMap
    val fullLine = (1 << n) - 1

    def nQueens(col: Int,
                mainDiagonal: Int,
                semiDiagonal: Int,
                current: List[Int]): Unit = {
      if (col == fullLine) {
        buffer += current.reverse.map(logCache)
      } else {
        var positions = fullLine & ~(col | mainDiagonal | semiDiagonal)
        while (positions != 0) {
          val nextPosition = positions & -positions
          nQueens(col | nextPosition,
            (mainDiagonal | nextPosition) << 1,
            (semiDiagonal | nextPosition) >> 1,
            nextPosition :: current)

          positions = positions & ~nextPosition
        }
      }
    }

    nQueens(0, 0, 0, Nil)
    buffer.map { row =>
      row.map { r =>
        (0 until n).map {
          case `r` => 'Q'
          case _ => '.'
        }.mkString
      }
    }.result
  }
}