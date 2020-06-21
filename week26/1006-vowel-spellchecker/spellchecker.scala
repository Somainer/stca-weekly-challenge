object Solution {
  def spellchecker(wordList: Array[String], queries: Array[String]): Array[String] = {
    def replaceVowel(s: String): String = s.toLowerCase.replaceAll("[aeiou]", "a")
    val reversedWords = wordList.reverse
    val allSet = reversedWords.toSet
    val caselessMap = reversedWords.map(x => x.toLowerCase -> x).toMap
    val vowelMap = reversedWords.map { s => replaceVowel(s) -> s }.toMap
    queries.map(s =>
      if (allSet contains s) s
      else caselessMap.get(s.toLowerCase()).orElse(vowelMap.get(replaceVowel(s))).getOrElse(""))
  }
}