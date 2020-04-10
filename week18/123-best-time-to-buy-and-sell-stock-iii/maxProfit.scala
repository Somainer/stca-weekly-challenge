object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.isEmpty) 0
    else {
      val leftMaxes = prices.scanLeft(prices.head -> 0) {
        case ((min, profit), price) =>
          val newMin = min min price
          val newProfit = profit.max(price - newMin)
          (newMin, newProfit)
      }.tail.map(_._2)
      val rightMaxes = prices.scanRight(prices.last -> 0) {
        case (price, (max, profit)) =>
          val newMax = max max price
          val newProfit = profit.max(newMax - price)
          (newMax, newProfit)
      }.init.map(_._2)
      prices.indices.map { i =>
        leftMaxes(i) + rightMaxes(i)
      }.max
    }
  }
}