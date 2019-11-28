/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
 object Solution {
    @annotation.tailrec
    def nodeAt(node: ListNode, index: Int = 0): Option[ListNode] =
      if (index == 0) Some(node)
      else if(node eq null) None
      else nodeAt(node.next, index - 1)
  
    def reverseKGroup(head: ListNode, k: Int): ListNode = {
      nodeAt(head, k).map(node => {
        val reversed = reverseKGroup(node, k)
        (1 to k).foldLeft(reversed -> head) {
          case ((reversed, p), _) =>
            val n = new ListNode(p.x)
            n.next = reversed
            n -> p.next
        }._1
      }).getOrElse(head)
    }
  }