object Solution {
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val stack = collection.mutable.Stack.empty[Int]
    val cache = collection.mutable.Map.empty[Int, Int]

    nums2.foreach { x =>
      while (stack.headOption.exists(_ < x)) cache.put(stack.pop(), x)
      stack.push(x)
    }
    
    stack.foreach(cache.put(_, -1))
    
    nums1 map cache
  }
}