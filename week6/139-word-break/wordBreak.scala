object Solution {
  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    val wordSet = wordDict.toSet
    val dp = Array.fill(s.length + 1)(false)
    dp(0) = true
    dp.indices.foreach{ i =>
      dp(i) ||= 
        0.until(i)
          .filter(dp)
          .exists(j => wordSet.contains(s.substring(j, i)))
    }
    dp.last
  }
}