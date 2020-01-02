object Solution {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    var curTank, startPos = 0
    val deltas = gas.zip(cost).view.map(Function.tupled(_ - _))
    deltas.zipWithIndex.foreach { case (delta, i) =>
      curTank += delta
      if (curTank < 0) {
        startPos = i + 1
        curTank = 0
      }
    }
    if (deltas.sum >= 0) startPos else -1
  }
}