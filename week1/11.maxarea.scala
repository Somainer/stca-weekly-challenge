object Solution {
  def maxArea(height: Array[Int]): Int = {
    height.foldLeft((0, height.length - 1, 0)) {
      case ((left, right, area), h) =>
        val maxHeight = area max (height(left).min(height(right)) * (right - left))
        if (height(left) < height(right)) (left + 1, right, maxHeight)
        else (left, right - 1, maxHeight)
    }._3
  }
}