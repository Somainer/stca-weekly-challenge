object Solution {
  def numPairsDivisibleBy60(time: Array[Int]): Int = {
    val remainder = Array.fill(60)(0)
    var count = 0
    time.map(_ % 60).foreach { i =>
      if (i == 0) {
        count += remainder.head
      } else count += remainder(60 - i)
      remainder(i) += 1
    }
    count
  }
}