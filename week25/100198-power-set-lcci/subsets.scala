object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    nums.toList.foldLeft[List[List[Int]]](Nil :: Nil) {
      case (xs, x) => xs ::: xs.map(x :: _)
    }
  }
}
