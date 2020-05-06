object Solution {
  def findTheDifference(s: String, t: String): Char = {
    (t.sum - s.sum).toChar
  }
}