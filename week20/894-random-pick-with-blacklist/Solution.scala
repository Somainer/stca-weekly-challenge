class Solution(_N: Int, _blacklist: Array[Int]) {
  private val size = _N - _blacklist.length
  private val mapping = {
    val c = collection.mutable.HashMap.empty[Int, Int]
    val blackList = _blacklist.toSet
    val start = (size.until(_N).toSet -- blackList).iterator
    blackList.foreach { i =>
      if (i < size) c.update(i, start.next())
    }
    c
  }
  def pick(): Int = {
    val random = util.Random.nextInt(size)
    mapping.getOrElse(random, random)
  }
}
/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(N, blacklist)
 * var param_1 = obj.pick()
 */