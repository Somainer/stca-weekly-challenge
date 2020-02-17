object Solution {
  def singleNumber(nums: Array[Int]): Int = {
    nums.foldLeft(0 -> 0) { case ((a, b), n) =>
      val nB = (b ^ n) & ~a
      val nA = (a ^ n) & ~nB
      nA -> nB
    }._2
  }
}