object Solution {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    if (matrix.isEmpty) Nil
    else matrix.head.toList ++ spiralOrder(matrix.tail.transpose.reverse)
  }
}