object Solution {
  def lengthOfLIS(nums: Array[Int]): Int = {
    val dp = Array.fill(nums.length)(1)
    dp.indices.foreach{ i =>
      dp(i) = dp(i).max((0 until i).filter(nums(_) < nums(i)).map(dp(_) + 1) match {
        case xs if xs.isEmpty => 1
        case xs => xs.max
      })
    }
    if (dp.isEmpty) 0 else dp.max
  }
}