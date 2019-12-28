class NumArray(_nums: Array[Int]) {
  private val cache = _nums.scan(0)(_ + _)
  def sumRange(i: Int, j: Int): Int = {
    cache(j + 1) - cache(i)
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */