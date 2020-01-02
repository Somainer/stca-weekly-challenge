object Solution {
  def maxProfit(prices: Array[Int]): Int = prices match {
    case Array() => 0
    case _ => prices.tail.zip(prices).map(Function.tupled(_ - _)).filter(_ > 0).sum
  }
}