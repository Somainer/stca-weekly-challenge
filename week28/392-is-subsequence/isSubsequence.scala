object Solution {
  def isSubsequence(s: String, t: String): Boolean = {
    val sit = s.iterator.buffered
    val tit = t.iterator.buffered
    while (sit.hasNext && tit.hasNext) {
      if (sit.head == tit.head) sit.next()
      tit.next()
    }

    sit.isEmpty
  }
}