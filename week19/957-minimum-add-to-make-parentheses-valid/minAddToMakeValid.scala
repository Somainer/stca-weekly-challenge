object Solution {
  def minAddToMakeValid(S: String): Int = {
      val (open, close) = S.foldLeft(0 -> 0) { case ((open, close), c) =>
        if (c == '(') (open + 1, close)
        else if (open != 0) (open - 1, close)
        else (open, close + 1)
      }
      open + close
  }
}