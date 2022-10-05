//https://leetcode.com/problemset/all?search=72
class Solution {
	fun printArray(a : Array<IntArray>) {
		a.forEach { println(it.toList()) }
	}
	fun minDistance(word1: String, word2: String): Int {
		if (word1.length < 1) {
			return word2.length
		}
		if (word2.length < 1) {
			return word1.length
		}
		var d = Array(word2.length + 1, { IntArray(word1.length + 1) })
		d.forEachIndexed {i, r -> r[0] = i }
		d.first().forEachIndexed{i, c -> d[0][i] = i }
		for(i in 1..word2.length) {
			val c1 = word2[i-1]
			for(j in 1..word1.length) {
				val c2 = word1[j-1]
				var o = if (c1 == c2) 0 else 1
				if (j > i) {
					d[i][j] = d[i][j-1] 
				} else if (j < i) {
					d[i][j] = d[i-1][j]
				} else {
					d[i][j] = d[i-1][j-1]
				}
				d[i][j] += o
			}
		}
		return d.last().last()
	}

}

fun main(args: Array<String>) {
	val r = Solution().minDistance("horse", "ros")
	println(r)
}
