/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def invertTree(root: TreeNode): TreeNode = {
    if (root eq null) null
    else {
      val node = new TreeNode(root.value)
      node.left = invertTree(root.right)
      node.right = invertTree(root.left)
      node
    }
  }
}