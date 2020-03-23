/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def largestValues(root: TreeNode): List[Int] = {
    val que = collection.mutable.Queue.empty[(TreeNode, Int)]
    val maxValues = collection.mutable.Map.empty[Int, Int]
    def add(node: TreeNode, depth: Int): Unit = {
      if (node ne null) {
        val value = maxValues.getOrElseUpdate(depth, node.value)
        if (value < node.value) maxValues(depth) = node.value
        que.enqueue((node, depth))
      }
    }
    add(root, 0)
    while (que.nonEmpty) {
      val (node, depth) = que.dequeue()
      add(node.left, depth + 1)
      add(node.right, depth + 1)
    }

    maxValues.toIndexedSeq.sortBy(_._1).map(_._2).toList
  }
}