/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def rightSideView(root: TreeNode): List[Int] = {
    def traverse(root: TreeNode, depth: Int): Map[Int, Int] = root match {
      case null => Map.empty
      case node =>
        traverse(node.left, depth + 1) ++ traverse(node.right, depth + 1) updated (depth, node.value)
    }
    
    traverse(root, 0).toSeq.sortBy(_._1).map(_._2).toList
  }
}