//https://leetcode.com/problemset/all?search=40
//https://leetcode.com/problems/combination-sum-ii/
class Solution {
	private fun combinationSum2Impl(
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
		for(j in i+1 until source.size) {
			if (j > i+1 && source[j] == source[j-1]) {
				continue
			}
			currentList.add(source[j])
			combinationSum2Impl(target - source[j], source, j, currentList, result)
			currentList.removeAt(currentList.lastIndex)
		}
	}

	fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
		var result = mutableListOf<List<Int>>()
		candidates.sort()
		var source = candidates.filter({ it < target })
		//println(source)
		for(i in 0 until source.size) {
			if (i > 0 && source[i] == source[i-1]) {
				continue
			}
			combinationSum2Impl(target - source[i], source, i, mutableListOf<Int>(source[i]), result)
		}
		if (candidates.any({ it == target})) {
			result.add(listOf(target))
		}
		return result
	}
}