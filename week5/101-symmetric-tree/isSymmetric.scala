/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def isSymmetric(left: TreeNode, right: TreeNode): Boolean = {
    if ((left eq null) && (right eq null)) true
    else if ((left eq null) || (right eq null)) false
    else (left.value == right.value) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)
  }
  def isSymmetric(root: TreeNode): Boolean = {
    isSymmetric(root, root)
  }
}
