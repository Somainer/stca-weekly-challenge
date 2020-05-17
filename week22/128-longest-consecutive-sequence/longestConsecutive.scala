object Solution {
  def longestConsecutive(nums: Array[Int]): Int = {
    val set = nums.toSet
    set.filterNot(i => set.contains(i - 1)).map { i =>
      Iterator.from(i).takeWhile(set.contains).length
    }.maxOption.getOrElse(0)
  }
}