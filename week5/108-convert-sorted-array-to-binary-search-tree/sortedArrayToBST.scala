/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def sortedArrayToBST(nums: Array[Int]): TreeNode = nums match {
    case Array() => null
    case Array(x) => new TreeNode(x)
    case xs =>
      val (l, r) = xs.splitAt(xs.length >> 1)
      val node = new TreeNode(r.head)
      node.left = sortedArrayToBST(l)
      node.right = sortedArrayToBST(r.tail)
      node
  }
}