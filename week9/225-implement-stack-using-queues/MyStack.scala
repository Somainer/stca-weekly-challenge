class MyStack() {
  private val data = collection.mutable.Queue.empty[Int]

  /** Push element x onto stack. */
  def push(x: Int): Unit = {
    data.enqueue(x)
    data.indices.tail.foreach { _ =>
      data.enqueue(data.dequeue())
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  def pop(): Int = {
    data.dequeue()
  }

  /** Get the top element. */
  def top(): Int = {
    data.front
  }

  /** Returns whether the stack is empty. */
  def empty(): Boolean = {
    data.isEmpty
  }
}
/**
* Your MyStack object will be instantiated and called as such:
* var obj = new MyStack()
* obj.push(x)
* var param_2 = obj.pop()
* var param_3 = obj.top()
* var param_4 = obj.empty()
*/