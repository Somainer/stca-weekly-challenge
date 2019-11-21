object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    prices.headOption.map { init =>
      prices.foldLeft(init -> 0) {
        case ((min, profit), price) =>
          val newMin = min min price
          val newProfit = profit.max(price - newMin)
          (newMin, newProfit)
      }._2
    }.getOrElse(0)
  }
}