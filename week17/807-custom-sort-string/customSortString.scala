object Solution {
  def customSortString(S: String, T: String): String = {
    T.toSeq.sortBy(S indexOf _).toString
  }
}