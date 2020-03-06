/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def isPalindrome(head: ListNode): Boolean = {
    val list = Iterator.iterate(head)(_.next).takeWhile(_ ne null).map(_.x).toList
    list == list.reverse
  }
}