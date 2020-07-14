object Solution {
  def removeOuterParentheses(S: String): String = {
    val pairs = S.scanLeft((0, 0)) {
      case ((_, x), '(') => (x + 1, x + 1)
      case ((_, x), ')') => (x, x - 1)
      case ((_, x), _) => (x, x) // Impossible case, just to make the compiler happy.
    }.tail.map(_._1)

    S.indices.filter(pairs(_) > 1).map(S).mkString
  }
}