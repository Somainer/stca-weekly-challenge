object Solution {
  def shipWithinDays(weights: Array[Int], D: Int): Int = {
    @annotation.tailrec
    def binarySearch(from: Int, to: Int, check: Int => Boolean): Int = {
      if (from >= to) from
      else {
        val mid = (from + to) >> 1
        if (check(mid)) binarySearch(from, mid, check)
        else binarySearch(mid + 1, to, check)
      }
    }

    binarySearch(weights.max, weights.sum, weight => {
      weights.foldLeft((1, 0)) {
        case ((day, load), w) =>
          val newLoad = load + w
          if (newLoad > weight) (day + 1, w)
          else (day, newLoad)
      }._1 <= D
    })
  }
}