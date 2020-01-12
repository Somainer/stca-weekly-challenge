object Solution {
  def myPow(x: Double, n: Int): Double = n match {
    case 0 => 1
    case 1 => x
    case -1 => 1.0 / x
    case n =>
      val half = myPow(x, n >> 1)
      val rest = myPow(x, n & 1)
      half * half * rest
  }
}