//https://leetcode.com/problems/combination-sum/
class Solution {
	fun combinationSumImpl(
		target: Int,
		source: List<Int>,
	 	i: Int,
		currentList: MutableList<Int>,
		result: MutableList<List<Int>>
	) {
		if (target <= 0) {
			if (target == 0) {
				result.add(currentList.toList())
			}
			return
		}
		for(j in i until source.size) {
			currentList.add(source[j])
			combinationSumImpl(target - source[j], source, j, currentList, result)
			currentList.removeAt(currentList.lastIndex)
		}
	}

	fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
		val result = mutableListOf<List<Int>>()
		var source = candidates.filter({ it < target })
		for(i in 0 until source.size) {
			combinationSumImpl(target - source[i], source, i, mutableListOf(source[i]), result)
		}
		if(candidates.any({ it == target })) {
			result.add(listOf(target))
		}
		return result
	}
}