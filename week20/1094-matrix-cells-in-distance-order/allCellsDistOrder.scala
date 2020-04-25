object Solution {
  def allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array[Array[Int]] = {
    0.until(R).flatMap { row =>
      0.until(C).map(Array(row, _))
    }.toArray.sortBy { case Array(r, c) =>
      (r - r0).abs + (c - c0).abs
    }
  }
}