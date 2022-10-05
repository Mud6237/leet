//https://leetcode.com/problemset/all?search=24
//https://leetcode.com/problems/swap-nodes-in-pairs/
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */
class ListNode(var `val`: Int) {
	var next: ListNode? = null
}/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */
class ListNode(var `val`: Int) {
	var next: ListNode? = null
}
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
	fun swapPairs(head: ListNode?): ListNode? {
		val beforeHead = ListNode(0).apply {
			next = head
		}
		var prev = beforeHead
		var node = head
		while(node != null) {
			var next = node.next
			val nextNext = next?.next
			// swap
			val t = node
			node = next
			next = t
			// Reset the pointers
			prev.next = node ?: next
			node?.next = next
			next?.next = null
			prev = next
			// Next iteration
			node = nextNext
		}
		return beforeHead.next
	}
}


