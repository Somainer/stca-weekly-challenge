/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    val resultBuffer = collection.mutable.Map.empty[Int, collection.mutable.ListBuffer[Int]]

    def dfs(node: TreeNode, level: Int = 0): Unit = {
      if(node ne null) {
        val buffer = resultBuffer.getOrElseUpdate(level, collection.mutable.ListBuffer.empty)
        buffer += node.value
        dfs(node.left, level + 1)
        dfs(node.right, level + 1)
      }
    }

    dfs(root)

    resultBuffer.mapValues(_.result).toSeq.sortBy(_._1).map(_._2).toList
  }
}