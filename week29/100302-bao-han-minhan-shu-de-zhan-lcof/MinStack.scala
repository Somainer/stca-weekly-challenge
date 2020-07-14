class MinStack() {
  val stack = collection.mutable.Stack.empty[Int]
  val minStack = collection.mutable.Stack.empty[Int]

  def push(x: Int) {
    stack.push(x)
    if (minStack.headOption.forall(_ >= x)) minStack.push(x)
  }

  def pop() {
    val result = stack.pop()
    if (result == minStack.top) minStack.pop()
  }

  def top(): Int = {
    stack.top
  }

  def min(): Int = {
    minStack.top
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.min()
 */