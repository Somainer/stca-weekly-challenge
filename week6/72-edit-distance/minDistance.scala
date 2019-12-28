object Solution {
  class Lazy[+T](expr: => T) {
    lazy val value = expr
  }
  object Lazy {
    def apply[T](expr: => T): Lazy[T] = new Lazy(expr)
  }
  def minDistance(word1: String, word2: String): Int = {
    def genDp(i: Int, j: Int): Lazy[Int] = Lazy {
      if (i == 0 || j == 0) {
        if (i != 0) dp(i - 1)(j).value + 1
        else if(j != 0) dp(i)(j - 1).value + 1
        else 0
      }
      else if(word1.charAt(i - 1) != word2.charAt(j - 1)) {
        val add = dp(i - 1)(j).value
        val del = dp(i)(j - 1).value
        val edit = dp(i - 1)(j - 1).value
        add.min(del).min(edit) + 1
      }
      else dp(i - 1)(j - 1).value
    }
    lazy val dp = Array.tabulate(word1.length + 1, word2.length + 1)(genDp)
    dp.last.last.value
  }
}