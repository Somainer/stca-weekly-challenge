object Solution {
  def backspaceCompare(S: String, T: String): Boolean = {
    @annotation.tailrec def cut(s: String): String = {
      if (s contains '#') {
        cut(s.replaceAll("([^#]|^)#", ""))
      } else s
    }
    cut(S) == cut(T)
  }
}