//https://leetcode.com/problemset/all?search=33
//https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
	fun search(nums: IntArray, target: Int): Int {
		var i = 0
		var j = nums.lastIndex
		while(j > i && nums[j] < nums[i]) {
			val m = i + (j - i) / 2
			if (nums[m] >= nums[i]) {
				i = m + 1
			} else {
				j = m
			}
		}
		val notRotated = if (i == 0 && j == nums.lastIndex) true else false
		//println("i = $i , j = $j, notRotated = $notRotated")
		var result = if (notRotated) {
			nums.binarySearch(target)
		} else {
			val k = nums.binarySearch(target, 0, i)
			//println(" k = $k")
			if (k < 0) {
				val r = nums.binarySearch(target, i)
				r
			} else {
				k
			}
		}
		return Math.max(result, -1)
	}
}
