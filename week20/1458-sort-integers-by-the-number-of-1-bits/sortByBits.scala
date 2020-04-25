object Solution {
  def sortByBits(arr: Array[Int]): Array[Int] = {
    arr.sortBy(x => x.toLong + (Integer.bitCount(x).toLong << 32))
  }
}