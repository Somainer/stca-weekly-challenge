object Solution {
  def sumOfDistancesInTree(N: Int, edges: Array[Array[Int]]): Array[Int] = {
    val graph = collection.mutable.ArrayBuffer.fill(N)(collection.mutable.ArrayBuffer.empty[Int])
    for (Array(from, to) <- edges) {
      graph(from) += to
      graph(to) += from
    }
    val connects = Array.fill(N)(1)
    val results = Array.fill(N)(0)
    def getConnects(node: Int, parent: Option[Int] = None): Unit = {
      for (child <- graph(node) if !parent.contains(child)) {
        getConnects(child, Some(node))
        connects(node) += connects(child)
        results(node) += results(child) + connects(child)
      }
    }
    def aggregateResults(node: Int, parent: Option[Int] = None): Unit = {
      for (child <- graph(node) if !parent.contains(child); count = connects(child)) {
        results(child) = results(node) - count + N - count
        aggregateResults(child, Some(node))
      }
    }
    getConnects(0)
    aggregateResults(0)
    results
  }
}