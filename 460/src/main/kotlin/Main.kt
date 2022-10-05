// https://leetcode.com/problemset/all?search=460
// https://leetcode.com/problems/lfu-cache/discuss/94547/Java-O(1)-Solution-Using-Two-HashMap-and-One-DoubleLinkedList
import java.util.LinkedList
import LFUCache.Node
import LFUCache.DoublyLinkedList

class LFUCache(capacity: Int) {
	data class Node(
		val k: Int,
		var v: Int,
		var c: Int = 0,
		var next: Node? = null,
		var prev: Node? = null,
	)

	class DoublyLinkedList() {
		val sentinel: Node = Node(-1, -1)
		val head: Node = sentinel
		val tail: Node = sentinel
		var size: Int = 0
			private set

		init {
			head.next = tail
			tail.prev = head
		}

		fun addHead(node: Node) {
			head.next?.prev = node
			node.next = head.next
			node.prev = head
			head.next = node
			size += 1
		}

		fun remove(node:  Node) {
			node.prev?.next = node.next
			node.next?.prev = node.prev
			size = (size - 1).coerceIn(0, Int.MAX_VALUE)
		}

		fun removeLast(): Node? {
			if (tail.prev == sentinel) {
				return null
			}
			val last = tail.prev ?: return null
			remove(last)
			return last
		}
	}

	private val cap: Int = capacity
	private val nodeMap = hashMapOf<Int, Node>()
	private val countMap = hashMapOf<Int, DoublyLinkedList>()
	private var minFreq: Int = 0

	fun get(key: Int): Int {
		val n = nodeMap[key] ?: return -1
		update(n)
		return n.v
	}
	
	fun put(key: Int, value: Int) {
		if (cap <= 0) {
			return
		}
		var n = nodeMap[key]
		if (n != null) {
			n.v = value
			update(n)
		} else {
			n = Node(key, value)
			nodeMap[key] = n
			if (nodeMap.size > cap) {
				countMap[minFreq]?.let { linkedlist ->
					linkedlist.removeLast()?.let{ lastNode ->
						nodeMap.remove(lastNode.k)
					}
				}
			}
			minFreq = 1
			update(n)
		}
	}

	private fun update(node: Node) {
		countMap[node.c]?.let { 
			it.remove(node) 
			if (it.size == 0 && node.c == minFreq) {
				minFreq += 1
			}
		}
		node.c += 1
		val newList = countMap.getOrPut(node.c, { DoublyLinkedList() })
		newList.addHead(node)
	}
}


fun main(args: Array<String>) {
	val ddl = DoublyLinkedList()
	ddl.addHead(Node(10, 10))
	ddl.addHead(Node(20, 20))
	ddl.addHead(Node(30, 30))
	println("ddl.tail ${ddl.tail.k}")
	println("ddl.head ${ddl.head.k}")
	println("ddl.tail.prev ${ddl.tail.prev?.k}")
	ddl.removeLast()
	ddl.removeLast()
	ddl.removeLast()
	ddl.removeLast()
	ddl.removeLast()
	println("ddl.tail.prev ${ddl.tail.prev?.k}")
	println("ddl.size ${ddl.size}")
}
