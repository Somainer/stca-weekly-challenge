/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def middleNode(head: ListNode): ListNode = {
    @annotation.tailrec
    def traverse(slow: ListNode, fast: ListNode): ListNode = {
      if ((fast eq null) || (fast.next eq null)) slow
      else traverse(slow.next, fast.next.next)
    }
    
    traverse(head, head)
  }
}