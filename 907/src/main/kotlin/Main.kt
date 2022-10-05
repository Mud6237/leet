//https://leetcode.com/problemset/all?search=907
//https://leetcode.com/problems/sum-of-subarray-minimums/

class Solution {
	class SegmentTree(nums: IntArray) {
		private val items = IntArray(nums.size * 2)
		private val n = nums.size

		init {
			init(nums)
		}

		private fun init(nums: IntArray) {
			var j = items.lastIndex
			for(i in nums.lastIndex downTo 0) {
				items[j] = nums[i]
				j -= 1
			}
			while(j >= 0) {
				items[j] = Math.min(items[j * 2], items[j * 2 + 1])
				j -= 1
			}
		}

		fun min(x: Int, y: Int): Int {
			var a = x + n
			var b = y + n
			var m = Int.MAX_VALUE
			while(b > a) {
				if (a % 2 != 0) {
					m = Math.min(m, items[a])
					a += 1
				}
				if (b % 2 != 0) {
					b -= 1
					m = Math.min(m, items[b])
				}
				a = a/2
				b = b/2
			}
			return m
		}
	}
	fun sumSubarrayMins(arr: IntArray): Int {
		var totalSum = 0
		val mod = 1_000_000_007
		val less = IntArray(arr.size, { -1 })
		val lessStack = mutableListOf<Int>()
		for(i in 0 until arr.size) {
			while(lessStack.isNotEmpty() && arr[lessStack.last()] > arr[i]) {
				lessStack.removeAt(lessStack.lastIndex)
			}
			less[i] = if (lessStack.isEmpty()) -1 else lessStack.last()
			lessStack.add(i)
		}
		var res = IntArray(arr.size, { 0 })
		for((index, num) in arr.withIndex()) {
			val r = less[index]
			if (r >= 0) {
				val a = ((index - (r + 1)) * num) % mod
				res[index] = (a + num + res[r]) % mod
			} else {
				val a = (num * (index + 1)) % mod
				res[index] = a
			}
			totalSum = (totalSum + res[index]) % mod
		}
		//println(res.toList())
		//println(less.toList())
		return totalSum
	}
}