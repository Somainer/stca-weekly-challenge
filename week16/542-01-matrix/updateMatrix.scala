object Solution {
  def updateMatrix(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val minDist = matrix.map(_.map {
      case 0 => 0
      case _ => Int.MaxValue - 2
    })
    matrix.indices.foreach { i =>
      matrix(i).indices.foreach { j =>
        if (i > 0) minDist(i)(j) =
          minDist(i)(j).min(minDist(i - 1)(j) + 1)
        if (j > 0) minDist(i)(j) =
          minDist(i)(j).min(minDist(i)(j - 1) + 1)
      }
    }
    matrix.indices.reverse.foreach { i =>
      matrix(i).indices.reverse.foreach { j =>
        if (i + 1 < matrix.length) minDist(i)(j) =
          minDist(i)(j).min(minDist(i + 1)(j) + 1)
        if (j + 1 < matrix(i).length) minDist(i)(j) =
          minDist(i)(j).min(minDist(i)(j + 1) + 1)
      }
    }
    minDist
  }
}