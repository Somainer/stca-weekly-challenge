/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    val dummy = new ListNode(114514)
    dummy.next = head
    var slow = dummy
    var fast = Iterator.iterate(dummy)(_.next).drop(n + 1).next()
    while (fast ne null) {
      slow = slow.next
      fast = fast.next
    }
    slow.next = slow.next.next
    dummy.next
  }
}