object Solution {
  def isPerfectSquare(num: Int): Boolean = {
    @annotation.tailrec
    def newton(x: Long): Boolean = {
      if (x * x > num) newton((x + num / x) >>> 1)
      else x * x == num
    }
    if (num < 2) true else newton(num >> 1)
  }
}