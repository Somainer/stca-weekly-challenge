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
}