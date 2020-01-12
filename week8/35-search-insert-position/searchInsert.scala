object Solution {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    @annotation.tailrec
    def search(left: Int, right: Int): Int = 
      if (left < right) {
        val mid = (left + right) >>> 1
        val num = nums(mid)
        if (num == target) mid
        else if(num < target) search(mid + 1, right)
        else search(left, mid)
      } else left
    search(0, nums.length)
  }
}