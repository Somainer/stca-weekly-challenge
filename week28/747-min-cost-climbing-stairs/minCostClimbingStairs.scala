object Solution {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    def cached[T, U](f: (T, T => U) => U): T => U = {
      val cache = collection.mutable.Map.empty[T, U]
      def resFn(prop: T): U = {
        cache.getOrElseUpdate(prop, f(prop, resFn))
      }
      resFn
    }

    def minCost(idx: Int, self: Int => Int): Int = {
      if (idx == cost.length) 0
      else if (idx + 1 == cost.length) cost(idx)
      else self(idx + 1).min(self(idx + 2)) + cost(idx)
    }

    val c = cached(minCost)
    c(0) min c(1)
  }
}