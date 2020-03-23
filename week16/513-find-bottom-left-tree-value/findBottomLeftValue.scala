/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def findBottomLeftValue(root: TreeNode): Int = {
    val que = collection.mutable.Queue((root, 0))
    var result = root.value
    var maxDepth = 0
    def add(node: TreeNode, depth: Int): Unit = {
      if (node ne null) {
        if (depth > maxDepth) {
          maxDepth = depth
          result = node.value
        }
        que.enqueue((node, depth))
      }
    }
    
    while (que.nonEmpty) {
      val (node, depth) = que.dequeue()
      add(node.left, depth + 1)
      add(node.right, depth + 1)
    }
    
    result
  }
}