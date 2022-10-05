// https://leetcode.com/problems/reverse-nodes-in-k-group/
//https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11423/Short-but-recursive-Java-code-with-comments/12145

/* Definition for singly-linked list.*/
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
class Solution {
	fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
		var curr = head
		var count = 0
		while(curr != null && count < k) {
			curr = curr.next
			count += 1
		}
		if (count == k) {
			var prev = reverseKGroup(curr, k)
			var node = head
			while(count > 0) {
				val temp = node?.next
				node?.next = prev
				prev = node
				node = temp
				count -= 1
			}
			return prev
		}
		return head
	}
}

fun main(args: Array<String>) {
	println("Hello World!")
}
