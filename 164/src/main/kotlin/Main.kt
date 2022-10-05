// https://leetcode.com/problemset/all?search=164
// https://leetcode.com/problems/maximum-gap/
class Solution {
	fun maximumGap(nums: IntArray): Int {
		if (nums.size < 2) { return 0 }
		var max = Int.MIN_VALUE
		var min = Int.MAX_VALUE
		for(n in nums) {
			max = Math.max(max, n)
			min = Math.min(min, n)
		}
		val totalGap = max - min
		val minGap = Math.ceil(totalGap.toDouble() / (nums.size - 1)).toInt()
		if (minGap < 1) {
			return 0
		}
		val bucketsCount = Math.ceil(totalGap.toDouble() / minGap).toInt() + 1
		val bucketsMin = IntArray(bucketsCount, { Int.MAX_VALUE })
		val bucketsMax = IntArray(bucketsCount, { Int.MIN_VALUE })
		for(n in nums) {
			val bucketIndex = (n - min) / minGap
			bucketsMin[bucketIndex] = Math.min(bucketsMin[bucketIndex], n)
			bucketsMax[bucketIndex] = Math.max(bucketsMax[bucketIndex], n)
		}
		var prev = 0
		var maxGap = Int.MIN_VALUE
		for(i in 0 until bucketsMin.size) {
			if (bucketsMin[i] == Int.MAX_VALUE) {
				continue
			}
			maxGap = Math.max(maxGap, bucketsMin[i] - prev)
			prev = bucketsMax[i]
		}
		//println(bucketsMin.toList())
		//println(bucketsMax.toList())
		return maxGap
	}
}

fun main() {
	println(Solution().maximumGap(intArrayOf(8, 100, 58, 192)))
	println(Solution().maximumGap(intArrayOf(1, 2, 3, 4)))
	println(Solution().maximumGap(intArrayOf(2, 31, 3)))
	println(Solution().maximumGap(intArrayOf(0, 1)))
	println(Solution().maximumGap(intArrayOf(88, 7, 9)))
}
