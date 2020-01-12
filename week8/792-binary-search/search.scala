object Solution {
  def search(nums: Array[Int], target: Int): Int = {
    import scala.collection.mutable.IndexedSeqView // In 2.11
    @annotation.tailrec
    def find(in: IndexedSeqView[Int, Array[Int]], offsetIdx: Int = 0): Int = {
      if(in.isEmpty) -1
      else {
        val midIdx = in.length >>> 1
        val mid = in(midIdx)

        if (mid < target) find(in.slice(midIdx + 1, in.length), offsetIdx + midIdx + 1)
        else if (mid > target) find(in.slice(0, midIdx), offsetIdx)
        else midIdx + offsetIdx
      }
    }
    find(nums.view)
  }
}