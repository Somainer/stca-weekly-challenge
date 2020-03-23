object Solution {
  def orangesRotting(grid: Array[Array[Int]]): Int = {
    val rotted = for {
      row <- grid.indices
      col <- grid(row).indices
      if grid(row)(col) == 2
    } yield (row, col, 0)
    val que = collection.mutable.Queue.from(rotted)
    val dx = List(1, 0, -1, 0)
    val dy = List(0, 1, 0, -1)
    var time = 0
    while (que.nonEmpty) {
      val (row, col, generation) = que.dequeue()
      time = time.max(generation)
      for {
        (di, dj) <- dx.zip(dy)
        nR = row + di
        nC = col + dj
        if grid.lift(nR).flatMap(_.lift(nC)).contains(1)
      } {
        grid(nR)(nC) = 2
        que.enqueue((nR, nC, generation + 1))
      }
    }

    if(grid.exists(_.contains(1))) -1 else time
  }
}