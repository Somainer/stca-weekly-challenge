object Solution {
  def canPartitionKSubsets(nums: Array[Int], k: Int): Boolean = {
    val sortedNums = nums.sortWith(_ > _)
    val numsSum = nums.sum
    val average = sortedNums.sum / k
    if ((numsSum % k) != 0) false
    else if (nums.max > average) false
    else {
      val allUsed = (1 << nums.length) - 1
      def check(usedSet: Int, finishedPairs: Int, pairSum: Int): Boolean = {
        if (pairSum > average) false
        else if (pairSum == average) check(usedSet, finishedPairs + 1, 0)
        else if (finishedPairs >= k - 1) true
        else {
          nums.indices
            .filter(i => (usedSet & (1 << i)) == 0)
            .exists{ i =>
              val num = sortedNums(i)
              check(usedSet | (1 << i), finishedPairs, num + pairSum)
            }
        }
      }
      check(0, 0, 0)
    }
  }
}