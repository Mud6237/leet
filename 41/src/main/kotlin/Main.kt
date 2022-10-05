// https://leetcode.com/problemset/all?search=41
// https://leetcode.com/problems/first-missing-positive/
class Solution {
	fun firstMissingPositive(nums: IntArray): Int {
		val N = nums.size
		for(n in nums) {
			var k = n
			while (k > 0 && k <= N && nums[k-1] != k) {
				val a = nums[k-1]
				nums[k-1] = k
				k = a
			}
		}
		for(i in 0 until N) {
			if (nums[i] != i+1) {
				return i+1
			}
		}
		return 0
	}
}

fun main(args: Array<String>) {
}
