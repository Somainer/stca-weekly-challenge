object Solution {
  def isValid(s: String): Boolean = {
    val stack = collection.mutable.Stack.empty[Char]
    def isSym(left: Char)(right: Char) = left match {
      case '(' => right == ')'
      case '[' => right == ']'
      case '{' => right == '}'
      case _ => false
    }
    s.foreach {
      case c if stack.headOption.exists(isSym(_)(c)) => stack.pop()
      case c => stack.push(c)
    }
    stack.isEmpty
  }
}