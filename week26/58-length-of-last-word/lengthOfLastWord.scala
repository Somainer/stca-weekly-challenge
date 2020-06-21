object Solution {
  def lengthOfLastWord(s: String): Int = {
    s.trim.split("\\s+").lastOption.map(_.length).getOrElse(0)
  }
}