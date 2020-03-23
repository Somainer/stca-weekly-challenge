object Solution {
  def networkDelayTime(times: Array[Array[Int]], N: Int, K: Int): Int = {
    val edges = Array.fill(N)(collection.mutable.ArrayBuffer.empty[(Int, Int)])
    times foreach { case Array(from, to, cost) =>
      edges(from - 1).addOne((to - 1, cost))
    }
    val dist = Array.fill(N)(Int.MaxValue)
    dist(K - 1) = 0
    val que = collection.mutable.PriorityQueue((0, K - 1))
    while (que.nonEmpty) {
      val (distance, node) = que.dequeue()
      if (dist(node) >= distance) {
        edges(node) foreach { case (to, cost) =>
          val newDist = distance + cost
          if (dist(to) > newDist) {
            dist(to) = newDist
            que.enqueue((newDist, to))
          }
        }
      }
    }
    dist.foldLeft(0) {
      case (-1, _) => -1
      case (_, Int.MaxValue) => -1
      case (acc, x) => acc max x
    }
  }
}