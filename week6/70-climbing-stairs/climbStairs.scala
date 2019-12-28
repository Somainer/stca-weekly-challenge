object Solution {
  def climbStairs(n: Int): Int = {
    def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a + b)
    fibFrom(1, 1)(n)
  }
}