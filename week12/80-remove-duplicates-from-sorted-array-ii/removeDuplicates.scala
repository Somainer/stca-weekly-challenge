object Solution {
  def removeDuplicates(nums: Array[Int]): Int = {
    var i = 0
    nums.foreach { n =>
      if (i < 2 || n != nums(i - 2)) {
        nums(i) = n
        i += 1
      }
    }
    i
  }
}