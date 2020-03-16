object Solution {
  def letterCasePermutation(s: String): List[String] = {
    if (s.isEmpty) s :: Nil
    else {
      val head = s.head match {
        case x if x.isDigit => x :: Nil
        case x => x.toLower :: x.toUpper :: Nil
      }
      for {
        h <- head
        t <- letterCasePermutation(s.tail)
      } yield h + t
    }
  }
}