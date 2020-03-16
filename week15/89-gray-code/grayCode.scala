object Solution {
  def grayCode(n: Int): List[Int] = {
    if (n < 1) List(0)
    else {
      val last = grayCode(n - 1)
      last ::: last.reverseIterator.map((1 << (n - 1)).|).toList
    }
  }

  def grayCodeFromBitOp(n: Int): List[Int] = {
    0.until(1 << n).map(i => i.^(i >> 1)).toList
  }
}