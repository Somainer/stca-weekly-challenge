object Solution {
  def reversePairs(nums: Array[Int]): Int = {
    def mergeInplace(from: Int, to: Int): Unit = {
      val mid = (from + to) >>> 1
      val buffer = collection.mutable.ArrayBuffer.empty[Int]
      val left = nums.view.slice(from, mid + 1)
      val right = nums.view.slice(mid + 1, to + 1)
      val lIt = left.iterator.buffered
      val rIt = right.iterator.buffered

      while (lIt.hasNext && rIt.hasNext) {
        if (lIt.head > rIt.head) {
          buffer += rIt.next()
        } else {
          buffer += lIt.next()
        }
      }
      while (lIt.hasNext) buffer += lIt.next()
      while (rIt.hasNext) buffer += rIt.next()

      buffer.indices.foreach { i =>
        nums(i + from) = buffer(i)
      }
    }
    
    def peekCollectFirst[T, U](it: BufferedIterator[T])(pf: PartialFunction[T, U]): Option[U] = {
      while (it.hasNext) {
        if (pf.isDefinedAt(it.head)) return Some(pf(it.head))
        else it.next()
      }

      None
    }

    def merge(from: Int, to: Int): Int = {
      if (from >= to) 0
      else {
        val mid = (from + to) >>> 1
        val previous = merge(from, mid) + merge(mid + 1, to)
        val jit = (mid + 1).to(to).iterator.buffered
        val reversedPairsOnMerge = nums.view.slice(from, mid + 1).map { x =>
          peekCollectFirst(jit) {
            case i if x <= nums(i) * 2L => i - mid - 1
          }.getOrElse(to - mid)
        }.sum
        mergeInplace(from, to)
        previous + reversedPairsOnMerge
      }
    }

    merge(0, nums.length - 1)
  }
}