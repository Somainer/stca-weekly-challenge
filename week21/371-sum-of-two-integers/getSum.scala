object Solution {
  @annotation.tailrec
  def getSum(a: Int, b: Int): Int = {
    if (a == 0) b
    else if (b == 0) a
    else getSum((a & b) << 1, a ^ b)
  }
}