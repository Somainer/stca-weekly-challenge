/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def isValidBST(root: TreeNode): Boolean = {
    def traverse(node: TreeNode): List[Int] = {
      if (node eq null) Nil
      else traverse(node.left) ::: node.value :: traverse(node.right)
    }

    val traversed = traverse(root)
    traversed.isEmpty || traversed.zip(traversed.tail).forall(Function.tupled(_ < _))
  }
}