class MinStack() {
  private val data = collection.mutable.Stack.empty[Int]
  private val minStk = collection.mutable.Stack.empty[Int]


  def push(x: Int): Unit = {
    data.push(x)
    if (!minStk.headOption.exists(_ < x)) minStk.push(x)
  }

  def pop(): Unit = {
    val popped = data.pop()
    if (popped == minStk.top) minStk.pop()
  }

  def top(): Int = data.top

  def getMin(): Int = minStk.top
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */