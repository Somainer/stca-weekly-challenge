object Solution {
  def maxSubArray(nums: Array[Int]): Int = {
    var max = nums.head
    var sum = 0
    nums.foreach { x =>
      sum = (sum + x) max x
      max = max max sum
    }
    max
  }
}