// https://leetcode.com/problems/minimum-cost-to-merge-stones/

class Solution {
	fun printArray(input: Array<IntArray>) {
		val sb = StringBuilder()
		for(row in input) {
			println(row.toList())
		}
	}
	fun mergeStones(stones: IntArray, k: Int): Int {
		val dp = Array(stones.size, { IntArray(stones.size)})
		val n = stones.size
		val p = IntArray(stones.size + 1)
		for(j in 1..stones.size) {
			p[j] = p[j-1] + stones[j-1]
		}
		println("partial sum ${p.toList()}")
		for(l in k-1 until n) {
			println("Sub-problem of size ${l+1}")
			for(i in 0 until n-l) {
				val j = i + l
				val subProblem = stones.slice(i..j)
				println(" :Splitting $subProblem")
				val splitSb = StringBuilder()
				dp[i][j] = Int.MAX_VALUE
				for(m in i until j step k-1) {
					dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m+1][j])
					splitSb.append("${stones.slice(i..m)}, ${stones.slice(m+1..j)}\n  ")
				}
				println("${splitSb.toString()}")
				if ((j-i) % (k-1) == 0) {
					println("j = $j, $i")
					dp[i][j] += p[j + 1] - p[i]
				}
			}
		}
		printArray(dp)
		return dp.first().last()
	}
}

fun main(args: Array<String>) {
	println(Solution().mergeStones(intArrayOf(3,2,4,1), 2))
	println(Solution().mergeStones(intArrayOf(1,4,3,3,2), 3))
	println(Solution().mergeStones(intArrayOf(3,5,1,2,6), 3))
}
