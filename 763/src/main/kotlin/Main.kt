//https://leetcode.com/problemset/all?search=763
//https://leetcode.com/problems/partition-labels/

class Solution {
	fun partitionLabels(s: String): List<Int> {
		var indexesMap = IntArray(26, { -1 })
		for(i in 0 until s.length) {
			indexesMap[s[i] - 'a'] = i
		}
		var result = mutableListOf<Int>()
		var lastPartitionAt = -1
		var furthestIndex = -1
		var i = 0
		while(i < s.length) {
			val furthestIndexOfChar = indexesMap[s[i] - 'a']
			furthestIndex = Math.max(furthestIndex, furthestIndexOfChar)
			if (i == furthestIndex) {
				result.add(i - lastPartitionAt)
				lastPartitionAt = i
			}
			i += 1
		}
		return result
	}
}