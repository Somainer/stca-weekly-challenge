object Solution {
  def reverseOnlyLetters(S: String): String = {
    val it = S.filter(_.isLetter).reverseIterator
    S.map {
      case x if x.isLetter => it.next()
      case x => x
    }
  }
}