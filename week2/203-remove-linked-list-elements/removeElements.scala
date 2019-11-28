/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
 object Solution {
    def removeElements(head: ListNode, value: Int): ListNode = {
      @annotation.tailrec
      def remove(node: ListNode, current: ListNode): Unit = {
        if(node ne null) {
          if (node.x == value) remove(node.next, current)
          else {
            current.next = new ListNode(node.x)
            remove(node.next, current.next)
          }
        }
      }
      val result = new ListNode()
      remove(head, result)
      result.next
    }
  }