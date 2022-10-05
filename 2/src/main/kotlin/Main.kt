//https://leetcode.com/problemset/all?search=2
//https://leetcode.com/problems/add-two-numbers/

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */

class ListNode(var `val`: Int) {
	var next: ListNode? = null
}

class Solution {
	companion object {
		fun toArrayList(head: ListNode?): List<Int> {
			val result = mutableListOf<Int>()
			var node = head
			while(node != null) {
				result.add(node.`val`)
				node = node.next
			}
			return result
		}
	}
	fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
		var beforeHead = ListNode(0)
		var prev = beforeHead
		var c = 0
		var node1 = l1
		var node2 = l2
		while(node1 != null || node2 != null || c > 0) {
			val a = node1?.`val` ?: 0
			val b = node2?.`val` ?: 0
			val s = a + b + c
			c = s / 10
			val newNode = ListNode(s % 10)
			prev.next = newNode
			prev = newNode
			node1 = node1?.next
			node2 = node2?.next
		}
		return beforeHead.next
	}
}