/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def hasPathSum(root: TreeNode, sum: Int): Boolean = {
    if (root eq null) false
    else if ((root.left eq null) && (root.right eq null)) sum == root.value
    else hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value)
  }
}