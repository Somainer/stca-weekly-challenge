object Solution {
  @annotation.tailrec
  def binarySearch(nums: Seq[Int], from: Int, to: Int, target: Int): Int = {
    if (from > to) -1
    else {
      val mid = (from + to) >>> 1
      if (nums(mid) == target) mid
      else {
        if (nums(from) <= nums(mid)) {
          if (target >= nums(from) && target < nums(mid))
            binarySearch(nums, from, mid - 1, target)
          else
            binarySearch(nums, mid + 1, to, target)
        } else {
          if (target > nums(mid) && target <= nums(to))
            binarySearch(nums, mid + 1, to, target)
          else
            binarySearch(nums, from, mid - 1, target)
        }
      }
    }
  }

  def search(nums: Array[Int], target: Int): Int = {
    binarySearch(nums, 0, nums.length - 1, target)
  }
}