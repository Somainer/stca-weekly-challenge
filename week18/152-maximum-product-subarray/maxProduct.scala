object Solution {
  def maxProduct(nums: Array[Int]): Int = {
    nums.to(LazyList).scanLeft((1, 1)) { case ((max, min), x) =>
      val iMax = (if (x < 0) min else max) * x
      val iMin = (if (x < 0) max else min) * x
      x.max(iMax) -> x.min(iMin)
    }.tail.foldLeft(nums.head)(_ max _._1)
  }
}