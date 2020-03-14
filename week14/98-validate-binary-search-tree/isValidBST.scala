/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def isValidBST(root: TreeNode): Boolean = {
    def valid(node: TreeNode, upper: Option[Int], lower: Option[Int]): Boolean =
      if (node eq null) true
      else if (upper.exists(node.value.>=) || lower.exists(node.value.<=)) false
      else valid(node.left, Some(node.value), lower) && valid(node.right, upper, Some(node.value))

    valid(root, None, None)
  }
}