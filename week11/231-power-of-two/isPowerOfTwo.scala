object Solution {
  def isPowerOfTwo(n: Int): Boolean = {
    (n > 0) && (n == (n & -n))
  }
}