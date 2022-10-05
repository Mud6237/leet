// https://leetcode.com/problemset/all?search=410

class Solution {
	fun splitArray(nums: IntArray, m: Int): Int {
		val res = nums.clone()
		for(i in 1 until res.size) {
			res[i] += res[i-1]
		}
		//println("m=1, ${res.toList()}")
		for(i in 2..m) {
			//res[i-1] = Math.max(nums[i-1], res[i-2])
			//println("Res before  = $i ${res.toList()}")
			//println("for m = $i ")
			for(j in res.lastIndex downTo i - 1) {
				var s = nums[j]
				var ms = Int.MAX_VALUE
				//println("Starting at s = $s")
				for(k in j-1 downTo i-2) {
					//println("s = $s, res = ${k}")
					ms = Math.min(Math.max(s, res[k]), ms)
					s += nums[k]
				}
				res[j] = ms
			}
			//println("m = $i, ${res.toList()}")
		}
		return res[res.lastIndex]
	}
}

fun main() {
	val nums = intArrayOf(5,2,1,4,6)
	//val nums = intArrayOf(1, 4, 4)
	val m = 3
	println(Solution().splitArray(nums, m))
}
