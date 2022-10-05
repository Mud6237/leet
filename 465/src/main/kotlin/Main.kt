//https://leetcode.com/problems/optimal-account-balancing/
class Solution {

	fun minTransfersImpl(s: Int, trans: MutableList<Int>): Int {
		if (s >= trans.size) {
			return 0
		}
		if (trans[s] == 0) {
			return minTransfersImpl(s + 1, trans)
		}
		var m = Int.MAX_VALUE
		for(i in s + 1 until trans.size) {
			if (trans[i] * trans[s] < 0) {
				val n = trans[i]
				trans[i] += trans[s]
				m = Math.min(m, 1 + minTransfersImpl(s + 1, trans))
				trans[i] = n
			}
		}
		return m
	}

	fun minTransfers(transactions: Array<IntArray>): Int {
		var maxId = Int.MIN_VALUE
		for(trans in transactions) {
			maxId = Math.max(Math.max(trans[0], trans[1]), maxId)
		}
		val trans = IntArray(maxId + 1)
		for(t in transactions) {
			trans[t[0]] -= t[2]
			trans[t[1]] += t[2]
		}
		val t = trans.filter{ it != 0 }.toMutableList()
		return minTransfersImpl(0, t)
	}
}

fun main() {
	val transactions = arrayOf(intArrayOf(1,5,1),intArrayOf(3,5,3),intArrayOf(5,2,2),intArrayOf(5,4,2))
	println(Solution().minTransfers(transactions))
}
