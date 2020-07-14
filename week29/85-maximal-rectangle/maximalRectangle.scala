object Solution {
  def largestRectangleArea(heights: Array[Int]): Int = {
    val fixedHeights = 0 +: heights :+ 0
    val stack = collection.mutable.Stack.empty[Int]
    var maxHeight = 0
    fixedHeights.view.zipWithIndex.foreach { case (h, i) =>
      while (stack.headOption.map(fixedHeights).exists(_ > h)) {
        val topHeight = fixedHeights(stack.pop())
        maxHeight = maxHeight.max(topHeight * (i - stack.top - 1))
      }
      stack.push(i)
    }
    maxHeight
  }

  def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    if (matrix.isEmpty) 0
    else {
      val dp = Array.fill(matrix.head.length)(0)
      matrix.map { row =>
        row.indices.foreach { col =>
          dp(col) = if (row(col) == '1') dp(col) + 1 else 0
        }
        largestRectangleArea(dp)
      }.max
    }
  }
}