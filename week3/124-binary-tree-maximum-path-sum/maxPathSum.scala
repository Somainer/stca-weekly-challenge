/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def maxPathSum(root: TreeNode): Int = {
    def maxSum(node: TreeNode, globalMax: Int): (Int, Int) = {
      if (node eq null) 0 -> globalMax
      else {
        val (leftSum, leftMax) = maxSum(node.left, globalMax)
        val (rightSum, rightMax) = maxSum(node.right, globalMax)
        val fullGetThrough = leftSum.max(0) + rightSum.max(0) + node.value
        val selectivePath = 0.max(leftSum max rightSum) + node.value
        selectivePath -> fullGetThrough.max(leftMax max rightMax)
      }
    }

    maxSum(root, Int.MinValue)._2
  }
}