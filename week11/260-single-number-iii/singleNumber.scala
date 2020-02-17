object Solution {
  def singleNumber(nums: Array[Int]): Array[Int] = {
    val mask = nums.reduce(_ ^ _)
    val lowBit = mask & -mask
    val oneOfNum = nums.filter(x => (x & lowBit) == 0).reduce(_ ^ _)
    Array(oneOfNum, mask ^ oneOfNum)
  }
}