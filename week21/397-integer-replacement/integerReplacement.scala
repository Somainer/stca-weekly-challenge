object Solution {
  def integerReplacement(n: Int): Int = {
    def count(n: Long): Int = n match {
      case 1 => 0
      case n if (n & 1) == 0 => count(n >> 1) + 1
      case n => count(n + 1).min(count(n - 1)) + 1
    }
    count(n.toLong)
  }
}