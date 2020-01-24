object Solution {
  def largestNumber(nums: Array[Int]): String = {
    if (nums.forall(_ == 0)) "0"
    else nums.sortWith((x, y) => s"$x$y" > s"$y$x").mkString
  }
}