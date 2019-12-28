object Solution {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val dp = Array.fill(amount + 1)(amount + 1)
    dp(0) = 0
    dp.indices.foreach { i =>
      coins.view.filter(_ <= i).foreach(v => dp.update(i, dp(i).min(dp(i - v) + 1)))
    }
    if(dp.last > amount) -1 else dp.last
  }
}