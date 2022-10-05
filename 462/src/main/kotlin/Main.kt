//https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
class Solution {
	fun minMoves2(nums: IntArray): Int {
		nums.sort()
		val mid = nums[nums.size/2]
		var moves = 0
		for(num in nums) {
			moves += Math.abs(num - mid)
		}
		return moves
	}
}