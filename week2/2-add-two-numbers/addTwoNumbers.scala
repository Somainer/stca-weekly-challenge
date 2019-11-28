/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
 object Solution {
    implicit class ListNodeOps(node: ListNode) {
      def isNull = node eq null
      def valueOrDefault(n: Int) = if(node.isNull) n else node.x
      def value = valueOrDefault(0)
      def ?+(that: ListNode) = value + that.value
      def dummyNext = if(isNull) null else node.next
    }
  
    def addTwoNumbers(l1: ListNode, l2: ListNode, carry: Int = 0): ListNode = {
      if (l1.isNull && l2.isNull && carry == 0) null
      else {
        val node = new ListNode(l1 ?+ l2 + carry)
        node.next = addTwoNumbers(l1.dummyNext, l2.dummyNext, if(node.x >= 10) 1 else 0)
        node.x %= 10
        node
      }
    }
  }