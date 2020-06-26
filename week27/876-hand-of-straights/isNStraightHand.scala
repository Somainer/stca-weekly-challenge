object Solution {
  def isNStraightHand(hand: Array[Int], W: Int): Boolean = {
    hand.length % W == 0 && {
      @annotation.tailrec
      def find(hands: List[Int], occur: Map[Int, Int]): Boolean = hands match {
        case Nil => true
        case head :: tail =>
          if (occur.getOrElse(head, 0) > 0) {
            val removeSeq = 0 until W map (head.+)
            if (removeSeq.forall(occur.getOrElse(_, 0) > 0))
              find(tail, removeSeq.foldLeft(occur) {
                case (m, r) => m.updated(r, m(r) - 1)
              })
            else false
          } else find(tail, occur)
      }
      val hands = hand.sortInPlace().toList
      find(hands, hands.groupMapReduce(identity)(Function.const(1))(_ + _))
    }
  }
}