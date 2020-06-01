/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def convertBST(root: TreeNode): TreeNode = {
    var sum = 0
    def go(node: TreeNode): Unit = {
      if (node ne null) {
        go(node.right)
        sum += node.value
        node.value = sum
        go(node.left)
      }
    }
    go(root)
    root
  }
}