object Solution {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    val lb = collection.mutable.ListBuffer.empty[List[Int]]
    def dfs(nums: List[Int], target: Int, selected: List[Int]): Unit = {
      if (target == 0) lb += selected.reverse
      else if (target > 0 && nums.nonEmpty) {
        dfs(nums, target - nums.head, nums.head :: selected)
        dfs(nums.tail, target, selected)
      }
    }
    dfs(candidates.toList, target, Nil)
    lb.result()
  }
}