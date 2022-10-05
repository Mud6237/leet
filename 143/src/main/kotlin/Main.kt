//https://leetcode.com/problems/reorder-list/
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
	fun reorderList(head: ListNode?): Unit {
		val stack = mutableListOf<ListNode>()
		var node = head
		var j = 0
		while(node != null) {
			stack.add(node)
			node = node.next
			j += 1
		}
		var i = 0
		node = head
		while(j > i) {
			val top = stack.removeAt(stack.lastIndex)
			val next = node?.next
			node?.next = top
			top.next = next
			node = next
			i += 1
			j -= 1
		}
		if (i > j) {
			node?.next?.next = null
		} else {
			node?.next = null
		}
	}
}
