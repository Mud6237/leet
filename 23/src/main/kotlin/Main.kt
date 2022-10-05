// https://leetcode.com/problemset/all?search=23
// https://leetcode.com/problems/merge-k-sorted-lists/

// https://leetcode.com/problems/merge-k-sorted-lists/discuss/10528/A-java-solution-based-on-Priority-Queue

import java.util.PriorityQueue


class ListNode(var `val`: Int) {
	var next: ListNode? = null
}

class Solution {
	companion object {
		fun makeList(a: List<Int>): ListNode? {
			var n: ListNode? = null
			for(v in a.asReversed()) {
				val node = ListNode(v)
				node.next = n
				n = node
			}
			return n
  	}
		fun printList(n: ListNode?): String {
			var node = n
			val sb = StringBuilder()
			while(node != null) {
				sb.append(node.`val`, "->")
				node = node.next
			}
			return sb.toString()
		}
	}
	fun mergeList(listA: ListNode?, listB: ListNode?): ListNode? {
		var nodeA: ListNode? = listA ?: return listB
		var nodeB: ListNode? = listB ?: return listA
		var head: ListNode? = null
		var n: ListNode? = null
		while(nodeA != null && nodeB != null) {
			val p = if (nodeB.`val` >= nodeA.`val` ) {
				val a = nodeA
				nodeA = nodeA.next
				a
			} else {
				val b = nodeB
				nodeB = nodeB.next
				b
			}
			head = head ?: p
			n?.next = p
			n = p
		}
		n?.next = nodeA ?: nodeB
		return head
	}
	
	fun naive_mergeKLists(lists: Array<ListNode?>): ListNode? {
		var result: ListNode? = null
		for(list in lists) {
			// val listA = Solution.printList(result)
			// val listB = Solution.printList(list)
			// println("Merging list ${listA}, ${listB}")
			result = mergeList(result, list)
			// println("Result list ${printList(result)}")
		}
		return result
	}

	fun mergeKLists(lists: Array<ListNode?>): ListNode? {
		val queue = PriorityQueue{nodeA: ListNode, nodeB: ListNode ->
			nodeA.`val` - nodeB.`val`
		}
		for(list in lists) {
			if (list != null)	 {
				queue.add(list)
			}
		}
		val head:ListNode = ListNode(0)
		var tail = head
		while(queue.isNotEmpty()) {
			val node = queue.poll()
			tail.next = node
			if (node.next != null) {
				queue.add(node.next)
			}
			tail = node
		}
		return head.next
	}


}


fun main(args: Array<String>) {
	val l = arrayOf( Solution.makeList(listOf(1,4,5)), Solution.makeList(listOf(1,3,4)), Solution.makeList(listOf(2,6)))
	// val list = l.map { Solution.makeList(it) }
	val o = listOf(1,1,2,3,4,4,5,6)
	val output = Solution.makeList(o)
	var r = Solution().mergeKLists(l)
	println(Solution.printList(r))
	
 }
