object Solution {
  def exclusiveTime(n: Int, logs: List[String]): Array[Int] = {
    object Num {
      def unapply(arg: String): Option[Int] = arg.toIntOption
    }

    val times = Array.fill(n)(0)
    val stack = collection.mutable.Stack.empty[(Int, Int)]
    logs.foreach {
      case s"${Num(id)}:start:${Num(time)}" =>
        stack.headOption.foreach {
          case (lastId, lastTime) => times(lastId) += time - lastTime
        }
        stack.push(id -> time)
      case s"${Num(id)}:end:${Num(time)}" =>
        val (`id`, startTime) = stack.pop()
        times(id) += time - startTime + 1
        if (stack.nonEmpty) {
          val (lastId, _) = stack.pop()
          stack.push((lastId, time + 1))
        }
    }
    times
  }
}