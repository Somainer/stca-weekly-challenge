object Solution {
  def restoreIpAddresses(s: String): List[String] = {
    (for {
      a <- 1 to 3
      b <- 1 to 3
      c <- 1 to 3
      d <- 1 to 3
      if a + b + c + d == s.length
      candidate = List(
        s.substring(0, a),
        s.substring(a, a + b),
        s.substring(a + b, a + b + c),
        s.substring(a + b + c, a + b + c + d))
      if candidate.forall(x => x == "0" || !x.startsWith("0"))
      if candidate.map(_.toInt).forall(_ < 256)
    } yield {
      candidate.mkString(".")
    }).toList
  }
}