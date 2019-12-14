object Solution {
  def permute(nums: Array[Int]): List[List[Int]] = {
    nums.permutations.toList.map(_.toList) // I admit it is pretty dirty.
  }
}