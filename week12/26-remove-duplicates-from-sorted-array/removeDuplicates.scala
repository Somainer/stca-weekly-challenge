object Solution {
  def removeDuplicates(nums: Array[Int]): Int = if (nums.isEmpty) 0 else {
    var i = 1
    nums.indices.tail.foreach { j =>
      if (nums(j) != nums(j - 1)) {
        nums(i) = nums(j)
        i += 1
      }
    }
    i
  }
}