object Solution {
  def isAnagram(s: String, t: String): Boolean = {
    s.sorted == t.sorted
  }
}