object Solution {
  def canThreePartsEqualSum(A: Array[Int]): Boolean = {
    val sum = A.sum
    sum % 3 == 0 && {
      val target = sum / 3
      val it = A.scanLeft(0)(_ + _).tail.iterator
      it.contains(target) && it.contains(target << 1) && it.nonEmpty
    }
  }
}