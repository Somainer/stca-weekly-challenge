object Solution {
  def letterCombinations(digits: String): List[String] = {
    val letters = IndexedSeq(
      "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    )

    digits.map(_ - '0').map(letters(_).map(_.toString)).foldLeft(List.empty[String]) {
      case (Nil, item) => item.toList
      case (acc, item) => for {
        head <- acc
        tail <- item
      } yield head + tail
    }
  }
}