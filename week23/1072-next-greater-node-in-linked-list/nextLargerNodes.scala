/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def nextLargerNodes(head: ListNode): Array[Int] = {
    val sequence = Iterator.iterate(head)(_.next).takeWhile(null.ne).map(_.x).toIndexedSeq
    val revId = sequence.indices.reverse
    val stack = collection.mutable.Stack.empty[Int]
    Array.tabulate(sequence.length) { j =>
      val i = revId(j)
      val current = sequence(i)
      stack.popWhile(current.>=)
      val result = stack.headOption.getOrElse(0)
      stack push current
      result
    }.reverse
  }
}