//https://leetcode.com/problemset/all?search=77
//https://leetcode.com/problems/combinations/
class Solution {
	fun combineImpl(
		source: IntArray,
		index: Int,
		currentList: MutableList<Int>,
		size: Int,
		result: MutableList<List<Int>>
	) {
		if (currentList.size == size) {
			result.add(currentList.toList())
			return
		}
		for(j in index..(source.size - (size - currentList.size))) {
			currentList.add(source[j])
			combineImpl(source, j+1, currentList, size, result)
			currentList.removeAt(currentList.lastIndex)
		}
	}

	fun combine(n: Int, k: Int): List<List<Int>> {
		val source = IntArray(n, { it + 1 })
		val result = mutableListOf<List<Int>>()
		combineImpl(source, 0, mutableListOf<Int>(), k, result)
		return result
	}
}
