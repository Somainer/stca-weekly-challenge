object Solution {
  def removeElement(nums: Array[Int], value: Int): Int = {
    var i = 0
    nums.indices.foreach { j =>
      if (nums(j) != value) {
        nums(i) = nums(j)
        i += 1
      }
    }
    i
  }
}