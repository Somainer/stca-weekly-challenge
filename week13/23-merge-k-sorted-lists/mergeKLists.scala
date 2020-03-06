/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def mergeKLists(lists: Array[ListNode]): ListNode = {
    def iterate(l: ListNode): Iterator[ListNode] = Iterator.iterate(l)(_.next).takeWhile(_ ne null)
    def mergeTwo(first: ListNode, second: ListNode): ListNode = {
      val dummy = new ListNode(114514)
      var p = dummy
      val it1 = iterate(first).buffered
      val it2 = iterate(second).buffered
      def advance(next: ListNode): Unit = {
        p.next = next
        p = p.next
      }
      while (it1.hasNext && it2.hasNext) {
        val it = if (it1.head.x < it2.head.x) it1 else it2
        advance(it.next())
      }
      it1 foreach advance
      it2 foreach advance
      dummy.next
    }

    if (lists.isEmpty) null
    else if (lists.length == 1) lists.head
    else {
      val partitionKey = lists.length >> 1
      val firstHalf = lists.slice(0, partitionKey)
      val secondHalf = lists.slice(partitionKey, lists.length)
      mergeTwo(mergeKLists(firstHalf), mergeKLists(secondHalf))
    }
  }
}