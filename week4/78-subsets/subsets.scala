object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    nums.foldLeft(List(List.empty[Int])) {
      case (acc, i) => acc ++ acc.map(i :: _)
    }
  }
}