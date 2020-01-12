object Solution {
  def mySqrt(x: Int): Int = {
    def newton(y: Long): Int =
      if (y * y <= x) y.toInt
      else newton((y + x / y) >>> 1)
    newton(x)
  }
}