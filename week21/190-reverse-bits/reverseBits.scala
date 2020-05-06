object Solution {
  def reverseBits(x: Int): Int = {
    Iterator.iterate(x)(_ >> 1).take(32).foldLeft(0) {
      case (n, i) => (n << 1) | (i & 1)
    }
  }
}