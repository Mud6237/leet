//https://leetcode.com/problems/lfu-cache/

class LFUCache(capacity: Int) {
		private data class Node(val k: Int, val v: Int) {
			constructor(k: Int, v: Int, next: Node, prev: Node): this(k, v) {
				this.next = next
				this.prev = prev
			}
			var next: Node
			var prev: Node
			init {
				next = this
				prev = this
			}
		}
		
		private inner class LinkedList() {
			private val sentinel = Node(Int.MIN_VALUE, Int.MIN_VALUE)
			private val beforeHead = sentinel
			private val afterTail = sentinel

			fun addTail(k: Int, v: Int): Node {
				val n = Node(k, v, afterTail, afterTail.prev)
				afterTail.prev.next = n
				afterTail.prev = n
				return n
			}

			fun isEmpty(): Boolean {
				return beforeHead.next === afterTail
			}

			fun removeHead(): Node? {
				val nodeToRemove = beforeHead.next
				if (!removeNode(nodeToRemove)) {
					return null
				}
				return nodeToRemove
			}

			fun removeNode(node: Node): Boolean {
				if (node === sentinel) {
					return false
				}
				val left = node.prev
				val right = node.next
				left.next = right
				right.prev = left
				return true
			}

			fun toList(): List<Pair<Int, Int>> {
				val r = mutableListOf<Pair<Int, Int>>()
				var h = beforeHead.next
				val t = afterTail
				while(h !== t) {
					r.add(h.k to h.v)
					h = h.next
				}
				return r
			}

			override fun toString() : String {
				return toList().toString()
			}

		}

		private val cap = capacity
		private val nodeFrequencyMap = hashMapOf<Int, LinkedList>()
		private val nodeMap = hashMapOf<Int, Pair<Int, Node>>()
		private var minCap = 1

    fun get(key: Int): Int {
			//println("[Get] key = $key")
			//println("Cache Before: $this")
			val nodeCountPair = nodeMap[key] ?: return -1
			removeFromCurrentFrequencyBucket(nodeCountPair)
			val frequency = nodeCountPair.first
			val value = nodeCountPair.second.v
			val newNode = addToNewFrequencyBucket(frequency + 1, key, value)
			//println("Cache After: $this")
			return newNode.v
		}

		private fun removeFromCurrentFrequencyBucket(nodeCountPair: Pair<Int, Node>) {
			val currentCount = nodeCountPair.first
			val node = nodeCountPair.second
			val linkedList = nodeFrequencyMap[currentCount]
			if (linkedList != null) {
				linkedList.removeNode(node)
				if (linkedList.isEmpty() && minCap == currentCount) {
					minCap += 1
				}
			}
		}

		private fun addToNewFrequencyBucket(frequency: Int, key: Int, value: Int): Node {
			val linkedList = nodeFrequencyMap.getOrPut(frequency, { LinkedList() })
			val node = linkedList.addTail(key, value)
			nodeMap[key] = (frequency to node)
			return node
		}

    fun put(key: Int, value: Int) {
			//println("[Put] key = $key, value = $value ")
			//println("Cache Before: $this")
			if (cap < 1) {
				return
			}
			val nodeCountPair = nodeMap[key]
			val frequency = nodeCountPair?.first ?: 0
			if(nodeCountPair != null) {
				removeFromCurrentFrequencyBucket(nodeCountPair)
			}
			if (nodeMap.size >= cap && nodeCountPair == null) {
				nodeFrequencyMap[minCap]?.let { linkedList ->
					linkedList.removeHead()?.let { removedNode -> 
						nodeMap.remove(removedNode.k)
					}
				}
			}
			addToNewFrequencyBucket(frequency + 1, key, value)
			minCap = Math.min(minCap, frequency + 1)
			//println("Cache After: $this")
		}

		override fun toString(): String {
			return "Cache:\n minCap = $minCap,\n nodeFrequencyMap = ${nodeFrequencyMap.toString()}\n nodeMap = ${nodeMap.toString()}"
		}

}

