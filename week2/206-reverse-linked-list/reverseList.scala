/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
 object Solution {
    def reverseList(head: ListNode): ListNode = {
      var result: ListNode = null
      var current = head
      while (current ne null) {
        val node = new ListNode(current.x)
        node.next = result
        result = node
        current = current.next
      }
      result
    }
  }