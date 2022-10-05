//https://leetcode.com/problemset/all?search=216
//https://leetcode.com/problems/combination-sum-iii/
class Solution {
	private fun combinationSum3Impl(
		target: Int,
		targetSize: Int,
		source: IntArray,
		i: Int,
		currentList: MutableList<Int>,
		result: MutableList<List<Int>>
	) {
		if (target <= 0) {
			if (target == 0 && currentList.size == targetSize) {
				result.add(currentList.toList())
			}
			return
		}
		if (currentList.size >= targetSize) {
			return
		}
		for(j in i+1 until source.size) {
			currentList.add(source[j])
			combinationSum3Impl(target - source[j], targetSize, source, j, currentList, result)
			currentList.removeAt(currentList.lastIndex)
		}
	}
	fun combinationSum3(k: Int, n: Int): List<List<Int>> {
		val source = IntArray(Math.min(n-1, 9), { it + 1 })
		val result = mutableListOf<List<Int>>()
		for(i in 0 until source.size) {
			combinationSum3Impl(n - source[i], k, source, i, mutableListOf<Int>(source[i]), result)
		}
		return result
	}
}