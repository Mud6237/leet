//https://leetcode.com/problemset/all?search=90
//https://leetcode.com/problems/subsets-ii/
class Solution {
	fun subsetsWithDup(nums: IntArray): List<List<Int>> {
		nums.sort()
		var result = mutableListOf(listOf(), listOf(nums.last()))
		var lastList = mutableListOf(listOf(nums.last()))
		for(i in nums.lastIndex-1 downTo 0) {
			var dup = false
			if(nums[i] == nums[i+1]) {
				dup = true
			}
			var nextList = mutableListOf<List<Int>>()
			val previousList = if (dup) lastList else result
			//println("num = ${nums[i]} previousList = ${previousList}")
			for(item in previousList) {
				nextList.add( item + nums[i] )
			}
			result.addAll(nextList)
			lastList = nextList
		}
		return result
	}
}