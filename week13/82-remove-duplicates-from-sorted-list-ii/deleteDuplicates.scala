/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def deleteDuplicates(head: ListNode): ListNode = {
    val dummy = new ListNode(114514)
    dummy.next = head
    var fast, slow = dummy
    while (fast ne null) {
      fast = fast.next
      while ((fast ne null) && (fast.next ne null) && fast.x == fast.next.x) {
        val fastVal = fast.x
        while ((fast ne null) && fast.x == fastVal) fast = fast.next
      }
      slow.next = fast
      slow = fast
    }
    dummy.next
  }
}