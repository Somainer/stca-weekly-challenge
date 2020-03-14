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
    def height(node: TreeNode): Int =
      if (node eq null) -1 else height(node.left).max(height(node.right)) + 1
    if (root eq null) true
    else if ((height(root.left) - height(root.right)).abs > 1) false
    else isBalanced(root.left) && isBalanced(root.right)
  }
}