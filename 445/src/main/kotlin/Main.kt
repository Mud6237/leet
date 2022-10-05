/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */
data class ListNode(var `val`: Int) {
	var next: ListNode? = null
}

class Solution {
	fun MutableList<ListNode>.removeLastOrNull(): ListNode? {
		if (this.size < 1) {
			return null
		}
		return this.removeAt(this.lastIndex)
	}
	fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
		var stack1 = mutableListOf<ListNode>()
		var stack2 = mutableListOf<ListNode>()
		var node1 = l1
		var node2 = l2
		while(node1 != null) {
			stack1.add(node1)
			node1 = node1.next
		}
		while(node2 != null) {
			stack2.add(node2)
			node2 = node2.next
		}
		var c = 0
		var newHead: ListNode? = null
		while(stack1.isNotEmpty() || stack2.isNotEmpty() || c > 0) {
			val a = stack1.removeLastOrNull()?.`val` ?: 0
			val b = stack2.removeLastOrNull()?.`val` ?: 0
			val s = a + b + c
			c =  s / 10
			val n = ListNode(s % 10)
			n.next = newHead
			newHead = n
		}
		return newHead
	}
}