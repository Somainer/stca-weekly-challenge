object Solution {
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    intervals.sortBy(_.head).foldLeft(Array[Array[Int]]()) {
      case (result, Array(from, to)) =>
        if (result.isEmpty) Array(Array(from, to))
        else {
          val Array(lastFrom, lastTo) = result.last
          if (from <= lastTo) result.init :+ Array(lastFrom, lastTo max to)
          else result :+ Array(from, to)
        }
    }
  }
}