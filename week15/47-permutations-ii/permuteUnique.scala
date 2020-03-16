object Solution {
  def permuteUnique(nums: Array[Int]): List[List[Int]] = {
    nums.sortInPlace()
    val result = collection.mutable.ListBuffer.empty[List[Int]]
    def permutations(nums: List[Int], current: List[Int]): Unit = {
      if (nums.isEmpty) result += current
      else {
        nums.indices.foreach { i =>
          if (i == 0 || nums(i) != nums(i - 1)) {
            val n = nums(i)
            permutations(nums.take(i) ::: nums.drop(i + 1), n :: current)
          }
        }
      }
    }
    permutations(nums.toList, Nil)
    result.result()
  }
}