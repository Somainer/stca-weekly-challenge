class CQueue() {
  val input, output = collection.mutable.Stack.empty[Int]
  
  private def flushOutput(): Unit = {
    if (output.isEmpty) {
      while (input.nonEmpty) output.push(input.pop())
    }
  }
  
  def appendTail(value: Int) {
    input.push(value)
  }

  def deleteHead(): Int = {
    flushOutput()

    if (output.isEmpty) -1
    else output.pop()
  }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * var obj = new CQueue()
 * obj.appendTail(value)
 * var param_2 = obj.deleteHead()
 */