object Solution {
  def canIWin(maxChooseInteger: Int, desiredTotal: Int): Boolean = {
    val cache = collection.mutable.Map.empty[Set[Int], Boolean]
    def dfs(available: Set[Int], target: Int): Boolean = cache.getOrElseUpdate(available, {
      available.collectFirst {
        case x if x >= target => true
        case n if !dfs(available - n, target - n) => true
      }.getOrElse(false)
    })
    val availableNums = 1.to(maxChooseInteger).toSet
    if (availableNums.sum < desiredTotal) false
    else dfs(availableNums, desiredTotal)
  }
}