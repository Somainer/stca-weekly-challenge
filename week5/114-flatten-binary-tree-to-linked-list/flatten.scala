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
  def lastNode(node: TreeNode, prev: TreeNode = null): TreeNode = node match {
    case null => prev
    case x => lastNode(x.right, x)
  }
  
  def flatten(root: TreeNode): Unit = root match {
    case null =>
    case node if (node.left eq null) && (node.right eq null) =>
    case node =>
      flatten(node.left)
      flatten(node.right)
      val last = lastNode(node.left)
      if (last ne null) {
        last.right = node.right
        node.right = node.left
      }
      node.left = null
  }
}