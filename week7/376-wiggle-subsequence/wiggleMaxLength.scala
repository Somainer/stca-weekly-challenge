object Solution {
  def wiggleMaxLength(nums: Array[Int]): Int = {
    if (nums.length < 2) nums.length
    else {
      val (up, down) = nums.view.zip(nums.view.tail).foldLeft((1, 1)) { case ((up, down), (lastNum, num)) =>
        if (lastNum < num) (down + 1, down)
        else if (lastNum > num) (up, up + 1)
        else (up, down)
      }
      up max down
    }
  }
}