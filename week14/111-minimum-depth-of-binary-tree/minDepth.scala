/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def minDepth(root: TreeNode): Int = {
    val q = collection.mutable.Queue.empty[(TreeNode, Int)]
    q.enqueue((root, 0))
    while (q.nonEmpty) {
      val (node, depth) = q.dequeue()
      if (node eq null) return depth
      if ((node.left eq null) && (node.right eq null)) return depth + 1
      if (node.left ne null) q.enqueue((node.left, depth + 1))
      if (node.right ne null) q.enqueue((node.right, depth + 1))
    }
    0
  }
}