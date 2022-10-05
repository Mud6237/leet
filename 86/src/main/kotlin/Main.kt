//https://leetcode.com/problems/partition-list/
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

fun ListNode?.toList(): List<Int> {
	var node = this
	val r = mutableListOf<Int>()
	while(node != null) {
		r.add(node.`val`)
		node = node.next
	}
	return r
}

class Solution {
	fun partition(head: ListNode?, x: Int): ListNode? {
		var node: ListNode? = head ?: return head
		val beforeLeft = ListNode(0)
		val beforeRight = ListNode(0)
		var left: ListNode = beforeLeft
		var right: ListNode = beforeRight
		while(node != null) {
			if(node.`val` < x) {
				left.next = node
				left = node
			} else {
				right.next = node
				right = node
			}
			node = node.next
		}
		right.next = null
		left.next = beforeRight.next
		return beforeLeft.next
	}
}