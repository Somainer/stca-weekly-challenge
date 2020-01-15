object Solution {
def evalRPN(tokens: Array[String]): Int = {
    val calcStack = collection.mutable.Stack.empty[Int]
    def performBiFn(f: (Int, Int) => Int): Unit = {
      val rhs = calcStack.pop()
      val lhs = calcStack.pop()
      calcStack.push(f(lhs, rhs))
    }

    tokens.foreach {
      case "+" => performBiFn(_ + _)
      case "-" => performBiFn(_ - _)
      case "*" => performBiFn(_ * _)
      case "/" => performBiFn(_ / _)
      case x => calcStack.push(x.toInt)
    }
    calcStack.top
  }
}