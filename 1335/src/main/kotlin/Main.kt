// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
class Solution {
	
	fun mergeIndexes(a: IntArray, n: Int): Pair<Int,Int> {
		var l = Int.MIN_VALUE
		var previousIndex = 0
		var endIndex = -1
		var startIndex = -1
		for( i in 1..n) {
			if (a[i] < 0) {
				continue
			}
			val m = Math.min(a[i], a[previousIndex])
			if (m >= l) {
				l = m
				startIndex = i
				endIndex = previousIndex
			}
			previousIndex = i
		}
		return Pair(startIndex, endIndex)
	}

	fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
		val n = jobDifficulty.size
		if (d > n) { 
			return -1
		}
		val a = jobDifficulty.copyOf()
		// println("Input a ${a.toList()}")
		for(i in d..jobDifficulty.lastIndex) {
			// println("For $v")
			val (i1, i2) = mergeIndexes(a, i)
			val li = if (a[i1] > a[i2]) i2  else i1
			// println("Pair ($i1, $i2) (${a[i1]}, ${a[i2]})")
			// println("replacing ${a[li]} with 0 ")
			a[li] = -1

			// println("Merge result ${a.toList()}")
		}
		return a.filter{ it > 0}.sum()
	}		
}

fun main() {
	/* var input = intArrayOf(6,5,4,3,2,1)
	var d = 2
	println(Solution().minDifficulty(input, d) == 7)
	input = intArrayOf(9,9,9)
	d = 4
	println(Solution().minDifficulty(input, d) == -1)
	input = intArrayOf(1,1,1)
	d = 3
	println(Solution().minDifficulty(input, d) == 3) */

	val input = intArrayOf(11,111,22,222,33,333,44,444)
	val d = 6
	println(Solution().minDifficulty(input, d))
}