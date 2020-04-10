object Solution {
  def nthUglyNumber(n: Int): Int = {
    val numbers = Array.fill(1690)(1)
    var p2, p3, p5 = 0
    numbers.indices.tail.foreach { i =>
      val x2 = numbers(p2) << 1
      val x3 = numbers(p3) * 3
      val x5 = numbers(p5) * 5
      val next = x2 min x3 min x5
      if (next == x2) p2 += 1
      if (next == x3) p3 += 1
      if (next == x5) p5 += 1
      numbers(i) = next
    }
    numbers(n - 1)
  }
}