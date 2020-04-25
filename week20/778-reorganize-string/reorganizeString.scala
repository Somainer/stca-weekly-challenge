object Solution {
  def reorganizeString(S: String): String = {
    val map = S.foldRight(Map.empty[Char, Int]) {
      case (c, map) => map.updatedWith(c)(_.orElse(Some(0)).map(_ + 1))
    }
    if (map.exists(_._2 > (S.length + 1) / 2)) ""
    else {
      val que = collection.mutable.PriorityQueue.from(map)(Ordering.by(_._2))
      val buff = new collection.mutable.StringBuilder
      while (que.length > 1) {
        val (ch, count) = que.dequeue()
        val (ch2, count2) = que.dequeue()
        if (buff.lastOption.contains(ch)) buff.append(ch2).append(ch)
        else buff.append(ch).append(ch2)
        if (count > 1) que.enqueue((ch, count - 1))
        if (count2 > 1) que.enqueue((ch2, count2 - 1))
      }
      que.lastOption.map(_._1).foreach(buff.append)
      buff.result()
    }
  }
}