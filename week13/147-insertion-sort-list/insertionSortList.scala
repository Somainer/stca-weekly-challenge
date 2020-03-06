/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def insertionSortList(head: ListNode): ListNode = {
    val dummy = new ListNode(0)
    Iterator.iterate(head)(_.next).takeWhile(_ ne null).foreach { node =>
      val toInsert = Iterator.iterate(dummy)(_.next).drop(1).takeWhile(_ ne null).toList.findLast(_.x <= node.x).getOrElse(dummy)
      val next = toInsert.next
      toInsert.next = new ListNode(node.x)
      toInsert.next.next = next
    }
    dummy.next
  }
}