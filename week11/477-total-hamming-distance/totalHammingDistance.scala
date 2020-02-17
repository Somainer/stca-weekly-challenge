object Solution {
  def totalHammingDistance(nums: Array[Int]): Int = {
    val counter = Array.fill(32)(0)
    nums.foreach { n =>
      n.toBinaryString.view.reverse.map(_ - '0').zipWithIndex.foreach { case (bit, idx) =>
        counter(idx) += bit
      }
    }
    counter.map(x => x * (nums.length - x)).sum
  }
}