/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def deleteDuplicates(head: ListNode): ListNode = {
    if (head.eq(null) || head.next.eq(null)) head
    else if (head.x == head.next.x) deleteDuplicates(head.next)
    else {
      head.next = deleteDuplicates(head.next)
      head
    }
  }
}