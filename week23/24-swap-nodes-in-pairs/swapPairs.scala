/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def swapPairs(head: ListNode): ListNode = {
    if (head.eq(null) || head.next.eq(null)) head
    else {
      val node = head.next
      val remaining = node.next
      node.next = head
      head.next = swapPairs(remaining)
      node
    }
  }
}