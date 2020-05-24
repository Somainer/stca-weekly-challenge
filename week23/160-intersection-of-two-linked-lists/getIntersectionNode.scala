/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

object Solution {
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    def genIt(node: ListNode) = Iterator.iterate(node)(_.next).takeWhile(_ ne null)
    val a = genIt(headA) ++ genIt(headB)
    val b = genIt(headB) ++ genIt(headA)
    @annotation.tailrec
    def go(ita: Iterator[ListNode], itb: Iterator[ListNode]): ListNode = {
      if (ita.hasNext && itb.hasNext) {
        val nextA = ita.next()
        val nextB = itb.next()
        if (nextA eq nextB) nextA else go(ita, itb)
      } else null
    }
    if(headA.ne(null) && headB.ne(null)) go(a, b)
    else null
  }
}