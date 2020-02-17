/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def getDecimalValue(head: ListNode): Int = {
    def traverse(node: ListNode, n: Int = 0): Int =
      if (node eq null) n
      else traverse(node.next, (n << 1) | node.x)
    
    traverse(head)
  }
}
