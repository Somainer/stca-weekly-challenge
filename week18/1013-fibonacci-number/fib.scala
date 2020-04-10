object Solution {
  def fib(N: Int): Int = {
    def fibs: LazyList[Int] = 0 #:: fibs.scanLeft(1)(_ + _)
    fibs(N)
  }
}