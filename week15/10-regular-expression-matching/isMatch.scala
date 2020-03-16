object Solution {
  def isMatch(s: String, p: String): Boolean = {
    @`inline` def matches(s: Char, p: Char) = p == '.' || s == p
    def testMatch(s: List[Char], p: List[Char]): Boolean = {
      if (p.isEmpty) s.isEmpty
      else p match {
        case c :: '*' :: cs =>
          val tailMatch = testMatch(s, cs)
          s match {
            case x :: xs if matches(x, c) => tailMatch || testMatch(xs, cs) || testMatch(xs, p)
            case _ => tailMatch
          }
        case c :: cs if s.nonEmpty && matches(s.head, c) => testMatch(s.tail, cs)
        case _ => false
      }
    }
    testMatch(s.toList, p.toList)
  }
}