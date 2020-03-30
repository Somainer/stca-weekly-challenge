object Solution {
  def detectCapitalUse(word: String): Boolean = word.matches("([A-Z]*|[A-Z]?[a-z]+)")
}