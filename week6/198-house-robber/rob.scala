object Solution {
  def rob(nums: Array[Int]): Int = {
    nums.foldLeft((0, 0)) {
      case ((previous, current), cur) =>
        current -> current.max(previous + cur)
    }._2
  }
}