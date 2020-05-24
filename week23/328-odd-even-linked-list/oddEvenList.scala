/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def oddEvenList(head: ListNode): ListNode = {
    if (head.eq(null) || head.next.eq(null)) head
    else {
      val odd = head
      val even = odd.next
      @annotation.tailrec def recur(odd: ListNode, even: ListNode): ListNode = {
        if (odd.next.eq(null) || even.next.eq(null)) odd
        else {
          odd.next = even.next
          val oddNext = odd.next
          even.next = oddNext.next
          recur(oddNext, even.next)
        }
      }
      recur(odd, even).next = even
      head
    }
  }
}