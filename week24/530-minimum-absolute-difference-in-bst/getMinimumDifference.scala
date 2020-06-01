/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def getMinimumDifference(root: TreeNode): Int = {
    def traverse(node: TreeNode): List[Int] = {
      if (node eq null) Nil
      else traverse(node.left) ::: node.value :: traverse(node.right)
    }
    val traversed = traverse(root)
    traversed.tail.zip(traversed).map(Function.tupled(_ - _)).min
  }
}