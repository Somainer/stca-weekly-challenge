/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def sumRootToLeaf(root: TreeNode): Int = {
    val modulo: Int = (1e9 + 7).toInt
    def sum(node: TreeNode, num: Int): Int = {
      if (node eq null) 0
      else {
        val current = (num << 1) | node.value
        if (node.left.eq(null) && node.right.eq(null)) current
        else (sum(node.left, current) + sum(node.right, current)) % modulo
      }
    }
    sum(root, 0)
  }
}