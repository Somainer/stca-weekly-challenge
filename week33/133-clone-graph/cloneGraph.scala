/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var neighbors: List[Node] = List()
 * }
 */

object Solution {
  def cloneGraph(graph: Node): Node = {
    val cache = collection.mutable.Map.empty[Node, Node]
    def cloneImpl(node: Node): Node = {
      if (node eq null) null
      else if (cache.contains(node)) cache(node)
      else {
        val copy = new Node(node.value)
        cache.update(node, copy)
        copy.neighbors = node.neighbors.map(cloneImpl)
        copy
      }
    }
    cloneImpl(graph)
  }
}
