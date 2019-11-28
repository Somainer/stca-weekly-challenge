/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
 object Solution {
    def linkedList(x: Int, tail: ListNode) = {
      val list = new ListNode(x)
      list.next = tail
      list
    }
    def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
      if (l1 eq null) l2
      else if(l2 eq null) l1
      else {
        if (l1.x < l2.x) linkedList(l1.x, mergeTwoLists(l1.next, l2))
        else linkedList(l2.x, mergeTwoLists(l1, l2.next))
      }
    }
  }