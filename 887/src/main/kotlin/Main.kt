//https://leetcode.com/problemset/all?search=887
//https://leetcode.com/problems/super-egg-drop/
class Solution {
	//## Begin -- Irrelevant
	fun intToDigit(v: Int): Char {
		if (v < 10) {
			return '0' + v
		} else {
			return 'a' + (v - 10)
		}
	}
	fun convertToRadix(n: Int, r: Int): Int {
		var a = CharArray(64)
		var length = 0
		var v = n
		while(v > 0) {
			a[length++] = intToDigit(v % r)
			v = v / r
		}
		var i = 0
		var j =  length - 1
		while(i < j) {
			val t = a[i]
			a[i] = a[j]
			a[j] = t
			i += 1
			j -= 1
		}
		return length
	}
	//## End-- Irrelevant

	fun superEggDropImpl(i: Int, n: Int, k: Int): Int {
		//println("For i = $i, n = $n,  k = $k")
		if ( n < i) {
			return 0
		}
		if (k == 1) {
			//println("Returning ${n - i }")
			return n - i
		}
		var m = Int.MAX_VALUE
		for(j in i..n) {
			//println("----(i = $i, n = ${j-1}, k = ${k-1}) & (i = ${j+1}, n = $n, k = ${k})")
			m = Math.min(m, 1 + Math.max( superEggDropImpl(i, j-1, k - 1), superEggDropImpl(j+1, n, k)))
		}
		return m
	}

	fun superEggDrop_bruteForce(k: Int, n: Int): Int {
		return superEggDropImpl(0, n, k)
	}

	fun superEggDrop(k: Int, n: Int): Int {
		val dp = Array(k+1, {IntArray(n + 1)})
		for(i in 1..n) {
			dp[1][i] = i
		}
		for(i in 1..k) {
			dp[i][1] = 1
		}
		for(j in 2..k) {
			for(i in 2..n) {
				var m = Int.MAX_VALUE
				for(y in i downTo 1) {
					m = Math.min(m, 1 + Math.max(dp[j-1][y-1], dp[j][i-y]) )
				}
				dp[j][i] = m
			}
		}
		return dp[k][n]
	}

}

fun main() {
	println(Solution().superEggDrop(1, 2))
	println(Solution().superEggDrop(2, 6))
	println(Solution().superEggDrop(3, 14))
}
