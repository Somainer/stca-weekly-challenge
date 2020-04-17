object Solution {
  def removeDuplicates(S: String): String = {
    @annotation.tailrec def remove(input: List[Char], state: List[Char]): String = input match {
      case Nil => state.mkString.reverse
      case c :: rest if state.headOption.contains(c) => remove(rest, state.tail)
      case c :: rest => remove(rest, c :: state)
    }
    remove(S.toList, Nil)
  }
}