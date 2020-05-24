/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def deleteNode(head: ListNode, value: Int): ListNode = {
    if (head eq null) null
    else if (head.x == value) deleteNode(head.next, value)
    else {
      head.next = deleteNode(head.next, value)
      head
    }
  }
}