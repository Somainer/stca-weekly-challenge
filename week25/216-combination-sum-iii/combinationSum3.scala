object Solution {
  def combinationSum3(k: Int, n: Int, from: Int = 0): List[List[Int]] = {
    if (n < 0) Nil
    else if (n == 0) {
      if (k == 0) Nil :: Nil
      else Nil
    }
    else (from + 1).to(9).flatMap(x => combinationSum3(k - 1, n - x, x).map(x :: _)).toList
  }
}
