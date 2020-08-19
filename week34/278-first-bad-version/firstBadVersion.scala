/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */

class Solution extends VersionControl {
  def firstBadVersion(n: Int): Int = {
    @annotation.tailrec
    def badVersionIn(from: Int, to: Int): Int = 
      if (from == to) from
      else {
        val mid = from + ((to - from) >> 1)
        if (isBadVersion(mid)) badVersionIn(from, mid)
        else badVersionIn(mid + 1, to)
      }
    badVersionIn(1, n)
  }
}
