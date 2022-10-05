//https://leetcode.com/problemset/all?search=632
//https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

class Solution {
	companion object {
		fun compare(x1: Int, y1: Int, x2: Int, y2: Int): Int {
			val d1 = y1 - x1
			val d2 = y2 - x2
			if (d1 == d2) {
				return x1 - x2
			}
			return d1 - d2
		}
	}
	fun smallestRange(nums: List<List<Int>>): IntArray {
		val indexes = IntArray(nums.size)
		var x = 0
		var y = Int.MAX_VALUE
		var done = false
		while(!done) {
			var j = 0
			var p = Int.MAX_VALUE
			var q = Int.MIN_VALUE
			for((i, numList) in nums.withIndex()) {
				val index = indexes[i]
				if (index > numList.lastIndex) {
					done = true
					break
				}
				if (numList[index] < p) {
					p = numList[index]
					j = i
				}
				q = Math.max(q, numList[index])
			}
			if (!done) {
				if (compare(p, q, x, y) < 0) {
					x = p
					y = q
				}
				indexes[j] += 1
			}
		}
		return intArrayOf(x, y)
	}
}

fun main(args: Array<String>) {
	println("Hello World!")
}
