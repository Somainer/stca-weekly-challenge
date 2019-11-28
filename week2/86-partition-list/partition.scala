/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
 object Solution {
    def filter(head: ListNode, predicate: Int => Boolean) = {
      val node = new ListNode()
      var p = node
      var current = head
      while (current ne null) {
        if (predicate(current.x)) {
          p.next = new ListNode(current.x)
          p = p.next
        }
        current = current.next
      }
      node.next -> p
    }
  
    def partition(head: ListNode, x: Int): ListNode = {
      val (result, tail) = filter(head, _ < x)
      tail.next = filter(head, _ >= x)._1
      if(result ne null) result else tail.next
    }
  }