object Solution {
  def arrayPairSum(nums: Array[Int]): Int = {
    nums.sortInPlace()
    Range(0, nums.length, 2).map(nums).sum
  }
}