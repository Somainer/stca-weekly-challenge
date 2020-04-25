object Solution {
  def sortString(s: String): String = {
    val sb = new StringBuilder
    val codePrints = s.map(_ - 'a')
    val buckets = Array.fill(26)(0)
    codePrints.foreach(buckets(_) += 1)
    def appender(i: Int) = {
      if (buckets(i) > 0) {
        sb.append((i + 'a').toChar)
        buckets(i) -= 1
      }
    }
    while (sb.lengthIs < s.length) {
      buckets.indices foreach appender
      buckets.indices.reverse foreach appender
    }
    sb.result()
  }
}