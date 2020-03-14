object Solution {
  def numTrees(n: Int): Int = {
    lazy val results: LazyList[Int] = 1 #:: LazyList.from(1).map { n =>
      0.until(n).iterator.map(i => results(i) * results(n - i - 1)).sum
    }
    results(n)
  }
}