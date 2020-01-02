object Solution {
  def jump(nums: Array[Int]): Int = {
    var maxDist, endPos, step = 0
    nums.init.view.zipWithIndex.foreach { case (jump, i) =>
      val toPos = jump + i
      maxDist = maxDist.max(toPos)
      if (endPos == i) {
        step += 1
        endPos = maxDist
      }
    }
    step
  }
}