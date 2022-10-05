/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list. */
class ListNode(var `val`: Int) {
	var next: ListNode? = null
}

class Solution {
	companion object {
		fun toArrayList(head: ListNode?): MutableList<Int> {
			val result = mutableListOf<Int>()
			var node = head
			while(node != null) {
				result.add(node.`val`)
				node = node.next
			}
			return result
		}
	}

	fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
		val stack = mutableListOf<ListNode>()
		var node = head
		var l: ListNode? = null
		var i = 1
		while(node != null && i <= right) {
			if (i < left) {
				l = node
			} else {
				stack.add(node)
			}
			node = node.next
			i += 1
		}
		val newHead = if (l == null && stack.isNotEmpty()) stack.last() else head
		val r: ListNode? = if(stack.isNotEmpty()) stack.last().next else null
		node = if (l != null) l else ListNode(0)
		while(stack.isNotEmpty()) {
			node?.next = stack.removeAt(stack.lastIndex)
			node = node?.next
		}
		node?.next = r
		return newHead
	}
}