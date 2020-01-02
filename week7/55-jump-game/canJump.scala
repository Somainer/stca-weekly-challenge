object Solution {
  def canJump(nums: Array[Int]): Boolean = {
    nums.view.zipWithIndex.foldLeft(0){ case (mx, (jump, idx)) =>
      if(mx >= idx) mx.max(idx + jump)
      else mx
    } >= (nums.length - 1)
  }
}