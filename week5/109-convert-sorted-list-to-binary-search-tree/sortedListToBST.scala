/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  @annotation.tailrec
  def getMiddleNode(node: ListNode, fastP: ListNode, prevP: ListNode): (ListNode, ListNode) = fastP match {
    case fn if (fn ne null) && (fn.next ne null) => getMiddleNode(node.next, fn.next.next, node)
    case _ => node -> prevP
  }

  def sortedListToBST(head: ListNode): TreeNode = head match {
    case null => null
    case node if node.next eq null => new TreeNode(node.x)
    case node =>
      val (middle, prevMiddle) = getMiddleNode(node, node, null)
      prevMiddle.next = null
      val result = new TreeNode(middle.x)
      result.left = sortedListToBST(head)
      result.right = sortedListToBST(middle.next)
      result
  }
}