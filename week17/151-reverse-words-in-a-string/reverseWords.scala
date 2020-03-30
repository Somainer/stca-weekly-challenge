object Solution {
  def reverseWords(s: String): String = {
    s.split("\\s+").reverseIterator.filter(_.nonEmpty).mkString(" ")
  }
}