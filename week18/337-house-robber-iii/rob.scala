/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def rob(root: TreeNode): Int = {
    def robImpl(node: TreeNode): (Int, Int) = {
      if (node eq null) (0, 0)
      else {
        val (leftKeep, leftSteal) = robImpl(node.left)
        val (rightKeep, rightSteal) = robImpl(node.right)
        val keep = leftKeep.max(leftSteal) + rightKeep.max(rightSteal)
        val steal = node.value + leftKeep + rightKeep
        (keep, steal)
      }
    }
    val (steal, keep) = robImpl(root)
    steal max keep
  }
}