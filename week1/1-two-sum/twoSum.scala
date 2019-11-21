object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    import collection.mutable
    val cache: mutable.Map[Int, Int] = mutable.Map.empty
    @annotation.tailrec
    def go(i: Int = 0): Array[Int] = {
      val toFind = target - nums(i)
      if (cache contains toFind) Array(cache(toFind), i)
      else {
        cache.update(nums(i), i)
        go(i + 1)
      }
    }
    go()
  }
}