/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def inorderTraversal(root: TreeNode): List[Int] = {
    val buffer = collection.mutable.ListBuffer.empty[Int]
    val stack = collection.mutable.Stack(root)
    val visited = collection.mutable.Set.empty[TreeNode]
    while (stack.nonEmpty) {
      val node = stack.pop()
      if (node ne null) {
        if (visited.contains(node)) {
          buffer += node.value
        } else {
          visited.add(node)
          stack.pushAll(Seq(
            node.left,
            node,
            node.right
          ).reverse)
        }
      }
    }
    buffer.result
  }
}