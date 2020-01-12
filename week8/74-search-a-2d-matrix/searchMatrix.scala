object Solution {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    if (matrix.isEmpty) false
    else {
      val rows = matrix.length
      val cols = matrix.head.length

      def search(i: Int, j: Int): Boolean = {
        if (i >= rows || j < 0) false
        else if (matrix(i)(j) < target) search(i + 1, j)
        else if (matrix(i)(j) > target) search(i, j - 1)
        else true
      }

      search(0, cols - 1)
    }
  }
}