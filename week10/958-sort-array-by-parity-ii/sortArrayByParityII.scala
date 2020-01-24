object Solution {
  def sortArrayByParityII(A: Array[Int]): Array[Int] = {
    val (odd, even) = A.partition(x => (x & 1) == 1)
    even.zip(odd).flatMap {
      case (x, y) => Array(x, y)
    }
  }
}