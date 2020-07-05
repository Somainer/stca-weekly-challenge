object Solution {
  def deleteAndEarn(nums: Array[Int]): Int = {
    val occurrence = Array.fill(10001)(0)
    nums.foreach(x => occurrence(x) += x)
    occurrence.foldLeft((0, 0)) {
      case ((keep, steal), cur) =>
        steal -> steal.max(keep + cur)
    }._2
  }
}