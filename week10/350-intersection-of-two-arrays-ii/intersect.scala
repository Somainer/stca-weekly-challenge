object Solution {
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val n1 = nums1.sorted
    val n2 = nums2.sorted
    val result = Array.newBuilder[Int]

    val it1 = n1.iterator.buffered
    val it2 = n2.iterator.buffered

    while (it1.hasNext && it2.hasNext) {
      if (it1.head < it2.head) it1.next()
      else if (it1.head > it2.head) it2.next()
      else {
        result += it1.next()
        it2.next()
      }
    }
    
    result.result()
  }
}