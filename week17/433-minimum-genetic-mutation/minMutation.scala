object Solution {
  def encodeDNAChain(chain: String): Int = {
    chain.reverseIterator.map {
      case 'A' => 0
      case 'T' => 1
      case 'C' => 2
      case 'G' => 3
    }.foldLeft(0) {
      case (acc, n) => (acc << 2) | n
    }
  }
  def minMutation(start: String, end: String, bank: Array[String]): Int = {
    val encodedBank = bank map encodeDNAChain
    val from = encodeDNAChain(start)
    val target = encodeDNAChain(end)
    val visited = collection.mutable.Set.empty[Int]
    val queue = collection.mutable.Queue(from -> 0)
    while (queue.nonEmpty) {
      val (current, step) = queue.dequeue()
      if (current == target) return step
      visited += current
      for {
        idx <- 0 until 8
        offset = idx * 2
        mask = 3 << offset
        diff <- 0 until 4
        fragment = diff << offset
        if fragment != (current & mask)
        newChain = (current & ~mask) | fragment
        if !visited.contains(newChain)
        if encodedBank.contains(newChain)
      } queue.enqueue((newChain, step + 1))
    }
    -1
  }
}