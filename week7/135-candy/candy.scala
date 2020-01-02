object Solution {
  def candy(ratings: Array[Int]): Int = {
    val candies = Array.fill(ratings.length)(1)
    ratings.indices.tail.foreach { i =>
      if (ratings(i) > ratings(i - 1)) candies(i) = candies(i - 1) + 1
    }
    ratings.indices.init.reverse.foreach { i => 
      if (ratings(i) > ratings(i + 1)) candies(i) = candies(i).max(candies(i + 1) + 1)
    }
    candies.sum
  }
}