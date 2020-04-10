object Solution {
  def rob(nums: Array[Int]): Int = {
    def robSingle(nums: Iterable[Int]): Int = {
      nums.foldLeft((0, 0)) {
        case ((previous, current), cur) =>
          current -> current.max(previous + cur)
      }._2
    }
    if (nums.length <= 1) nums.headOption.getOrElse(0)
    else {
      val numView = nums.view
      robSingle(numView.tail) max robSingle(numView.init)
    }
  }
}