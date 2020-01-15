class MyQueue() {
  private val in, out = collection.mutable.Stack.empty[Int]
  
  private def sync(): Unit = {
    if (out.isEmpty) {
      in.foreach(out.push)
      in.clear()
    }
  }

  /** Push element x to the back of queue. */
  def push(x: Int): Unit = in.push(x)

  /** Removes the element from in front of queue and returns that element. */
  def pop(): Int = {
    sync()
    out.pop()
  }

  /** Get the front element. */
  def peek(): Int = {
    sync()
    out.top
  }

  /** Returns whether the queue is empty. */
  def empty(): Boolean = {
    in.isEmpty && out.isEmpty
  }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */