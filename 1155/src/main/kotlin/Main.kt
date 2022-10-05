//https://leetcode.com/problemset/all?search=1155
//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
class Solution {
	fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
		if (target < n) {
			return 0
		}
		if (target > n * k) {
			return 0
		}
		if (n == 1) {
			return 1
		}
		val mod = 1_000_000_007
		val A = Array(n + 1, { IntArray(target + 1) })
		for(i in 1..Math.min(target, k)) {
			A[1][i] = 1
		}
		for(i in 2..n) {
			for(s in i..target) {
				for(j in 1..k) {
					if (s > j) {
						A[i][s] = (A[i][s] + A[i-1][s-j]) % mod
					}
				}
			}
		}
		return A[n][target]
	}
}
