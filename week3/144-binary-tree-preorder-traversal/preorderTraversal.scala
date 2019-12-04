/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def preorderTraversal(root: TreeNode): List[Int] = {
    import collection.mutable
    
    val stack = mutable.Stack(root)
    val buffer = mutable.ListBuffer.empty[Int]
    
    while (stack.nonEmpty) {
      val top = stack.pop()
      if (top ne null) {
        buffer += top.value
        stack.pushAll(Seq(top.left, top.right).reverse)
      }
    } 
    
    buffer.result()
  }
}