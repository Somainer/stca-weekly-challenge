object Solution {
  def maxScoreSightseeingPair(A: Array[Int]): Int = {
    A.indices.tail.foldLeft(A.head -> -1) {
      case ((left, res), i) =>
        val newRes = res.max(left + A(i) - i)
        val newLeft = left.max(A(i) + i)
        (newLeft, newRes)
    }._2
  }
}