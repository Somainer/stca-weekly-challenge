/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def buildTree(inOrder: Array[Int], postOrder: Array[Int]): TreeNode = {
    if (inOrder.isEmpty) null
    else {
      val rootValue = postOrder.last
      val rootIndex = inOrder.indexOf(rootValue)
      val root = new TreeNode(rootValue)
      root.left = buildTree(inOrder.slice(0, rootIndex), postOrder.slice(0, rootIndex))
      root.right = buildTree(inOrder.slice(rootIndex + 1, inOrder.length), postOrder.slice(rootIndex, postOrder.length - 1))
      root
    }
  }
}