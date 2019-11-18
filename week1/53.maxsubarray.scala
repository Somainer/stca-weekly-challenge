object Solution {
  def maxSubArray(nums: Array[Int]): Int = {
    nums.foldLeft(0 -> nums.head) {
      case ((sum, max), x) =>
        val currentSum = x max (sum + x)
        currentSum -> max.max(currentSum)
    }._2
  }
}