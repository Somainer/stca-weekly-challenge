/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def isBalanced(root: TreeNode): Boolean = {
    def depth(node: TreeNode): Int = {
      if (node eq null) 0
      else (1 + (depth(node.left) max depth(node.right)))
    }
    (root eq null) || {
      ((depth(root.left) - depth(root.right)).abs <= 1) && isBalanced(root.left) && isBalanced(root.right) 
    }
  }
}