/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def maxDepth(root: TreeNode): Int = {
    if (root eq null) 0
    else (maxDepth(root.left) max maxDepth(root.right)) + 1
  }
}