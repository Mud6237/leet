//https://leetcode.com/problemset/all?search=370
//https://leetcode.com/problems/range-addition
class Solution {
	fun getModifiedArray_bruteForce(length: Int, updates: Array<IntArray>): IntArray {
		val arr = IntArray(length)
		var prev = intArrayOf(0, -1, 0)
		var v = 0
		for(i in 0 until updates.size) {
			var curr = updates[i]
			if (prev[0] == curr[0] && prev[1] == curr[1]) {
				v += curr[2]
				prev = curr
				continue
			}
			for(j in prev[0]..prev[1]) {
				arr[j] += v
			}
			v = curr[2]
			prev = curr
		}
		for(i in prev[0]..prev[1]) {
			arr[i] += v
		}
		return arr
	}
	fun getModifiedArray(length: Int, updates: Array<IntArray>): IntArray {
		var arr = IntArray(length)
		for(update in updates) {
			var x = update[0]
			var y = update[1]
			var v = update[2]
			arr[x] += v
			if (y+1<arr.size) {
				arr[y+1] -= v
			}
		}
		for(i in 1 until arr.size) {
			arr[i] += arr[i-1]
		}
		return arr
	}
}