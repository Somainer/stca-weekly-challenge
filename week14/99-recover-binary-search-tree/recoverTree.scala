/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def recoverTree(root: TreeNode): Unit = {
    def inOrderTraverse(node: TreeNode, f: TreeNode => Unit): Unit = {
      if (node ne null) {
        inOrderTraverse(node.left, f)
        f(node)
        inOrderTraverse(node.right, f)
      }
    }
    var first, second, previous: TreeNode = null
    inOrderTraverse(root, { node =>
      if (previous.ne(null) && previous.value > node.value) {
        if (first eq null) first = previous
        second = node
      }
      previous = node
    })
    val firstValue = first.value
    first.value = second.value
    second.value = firstValue
  }
}