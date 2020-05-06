object Solution {
  def maxProduct(words: Array[String]): Int = {
    def encode(s: String): Int = s.view.map(_ - 'a').map(1.<<).reduceOption(_ | _).getOrElse(0)
    val encodedWords = words map encode
    for {
      i <- words.indices
      j <- words.indices
      if i != j
      if (encodedWords(i) & encodedWords(j)) == 0
    } yield words(i).length * words(j).length
  }.maxOption.getOrElse(0)
}