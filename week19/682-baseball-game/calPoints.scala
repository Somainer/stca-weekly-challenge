object Solution {
  def calPoints(ops: Array[String]): Int = {
    @annotation.tailrec def calc(ops: List[String], stk: List[Int]): Int = ops match {
      case Nil => stk.sum
      case "+" :: op => calc(op, (stk.head + stk.tail.head) :: stk)
      case "D" :: op => calc(op, stk.head * 2 :: stk)
      case "C" :: op => calc(op, stk.tail)
      case num :: op => calc(op, num.toInt :: stk)
    }

    calc(ops.toList, Nil)
  }
}