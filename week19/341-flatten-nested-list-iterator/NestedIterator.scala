/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *
 *   // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *   def isInteger: Boolean = {}
 *
 *   // Return the single integer that this NestedInteger holds, if it holds a single integer
 *   def getInteger: Int = {}
 *
 *   // Set this NestedInteger to hold a single integer.
 *   def setInteger(i: Int) = {}
 *
 *   // Return the nested list that this NestedInteger holds, if it holds a nested list
 *   def getList = {}
 *
 *   // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *   def add(ni: NestedInteger) = {}
 * }
 */

class NestedIterator(_nestedList: List[NestedInteger]) {
  def from(nl: Seq[NestedInteger]): LazyList[Int] = nl.to(LazyList).flatMap { ni =>
    if (ni.isInteger) LazyList(ni.getInteger)
    else from(ni.getList)
  }
  private val it = from(_nestedList).iterator
  def next(): Int = {
    it.next()
  }

  def hasNext(): Boolean = {
    it.hasNext
  }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = new NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */