object Solution {
  def waysToStep(n: Int): Int = {
    val modulo = 1000000007
    val ways = new Array[Int](n.max(3) + 1)
    ways(1) = 1
    ways(2) = 2
    ways(3) = 4
    4 to n foreach { i =>
      ways(i) =
        (((ways(i - 1) + ways(i - 2)) % modulo) + ways(i - 3)) % modulo
    }
    ways(n)
  }
}