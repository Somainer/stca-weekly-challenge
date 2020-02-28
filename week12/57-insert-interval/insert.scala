object Solution {
  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
    val Array(newFrom, newTo) = newInterval
    val result = collection.mutable.ArrayBuffer.empty[Array[Int]]
    def mergeLast(from: Int, to: Int) = {
      println(s"MergeLast $from -> $to")
      if (result.isEmpty) result += Array(from, to)
      else {
        val lastRange = result.last
        if (lastRange.last >= from) lastRange(1) = to max lastRange.last
        else result += Array(from, to)
      }
    }
    intervals.foreach { case Array(from, to) =>
      if (to < newFrom) result += Array(from, to)
      else if (from <= newTo) {
        val mFrom = from min newFrom
        val mTo = to max newTo
        mergeLast(mFrom, mTo)
      } else {
        mergeLast(newFrom, newTo)
        mergeLast(from, to)
      }
    }
    if (intervals.forall(_.last < newFrom)) result += newInterval

    result.toArray
  }
}