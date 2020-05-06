object Solution {
  def isPowerOfFour(num: Int): Boolean = {
    (num > 0) && ((num & -num) == num) & ((num & 0x55555555) != 0)
  }
}