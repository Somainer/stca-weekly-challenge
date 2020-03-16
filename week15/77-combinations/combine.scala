object Solution {
  def combine(n: Int, k: Int): List[List[Int]] = {
    if (k == 0) Nil :: Nil
    else if (n < k) Nil
    else {
      combine(n - 1, k - 1).map(n :: _) ::: combine(n - 1, k)
    }
  }
}