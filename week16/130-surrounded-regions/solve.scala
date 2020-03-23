object Solution {
  def solve(board: Array[Array[Char]]): Unit = {
    val noFill = board.map(_.map(_ => false))
    val dx = List(0, 1, 0, -1)
    val dy = List(1, 0, -1, 0)
    def dfs(x: Int, y: Int): Unit = if (!noFill(x)(y)) {
      noFill(x)(y) = true
      for {
        (dx, dy) <- dx.zip(dy)
        row = x + dx
        col = y + dy
        if board lift row flatMap (_ lift col) contains 'O'
      } dfs(row, col)
    }

    if (board.nonEmpty) board.head.indices.foreach { col =>
      if (board.head(col) == 'O') dfs(0, col)
      if (board.last(col) == 'O') dfs(board.length - 1, col)
    }
    board.indices.foreach { row =>
      if (board(row)(0) == 'O') dfs(row, 0)
      if (board(row).last == 'O') dfs(row, board(row).length - 1)
    }
    board.indices.foreach { i =>
      board(i).indices.foreach { j =>
        if (board(i)(j) == 'O' && !noFill(i)(j))  board(i)(j) = 'X'
      }
    }
  }
}