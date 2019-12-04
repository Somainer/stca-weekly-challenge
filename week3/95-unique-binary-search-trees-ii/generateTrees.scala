/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def generateTrees(n: Int): List[TreeNode] = {
    def gen(xs: Seq[Int]): Seq[TreeNode] = {
      if (xs.isEmpty) null :: Nil
      else {
        for {
          i <- xs.indices
          x = xs(i)
          (left, right) = xs splitAt i
          lch <- gen(left)
          rch <- gen(right drop 1)
        } yield {
          val node = new TreeNode(x)
          node.left = lch
          node.right = rch
          node
        }
      }
    }

    if (n == 0) Nil else gen(1 to n).toList
  }
}