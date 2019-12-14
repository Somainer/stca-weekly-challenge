object Solution {
  def readBinaryWatch(num: Int): List[String] = {
    for {
      h <- 0 to 11
      m <- 0 to 59
      if Integer.bitCount(m << 4 | h) == num
    } yield f"$h:$m%02d"
  }.toList
}