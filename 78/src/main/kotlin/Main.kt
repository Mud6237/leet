//https://leetcode.com/problems/subsets/
class Solution {
	fun subsets(nums: IntArray): List<List<Int>> {
		var result = mutableListOf<List<Int>>(listOf())
		var queue = mutableListOf<List<Int>>()
		queue.addAll(nums.mapIndexed({ index, _ -> listOf(index)}))
		result.addAll(nums.map({ listOf(it)}))
		var s = 1
		while(s < nums.size) {
			var nextQueue = mutableListOf<List<Int>>()
			for(l in queue) {
				for(j in l.last() + 1 until nums.size) {
					nextQueue.add(l + j)
				}
			}
			result.addAll(nextQueue.map({ it.map{ l -> nums[l]} }))
			queue = nextQueue
			s+=1 
		}
		return result
	}
}