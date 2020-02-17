object Solution {
  def singleNumber(nums: Array[Int]): Int = {
    nums.reduce(_ ^ _)
  }
}