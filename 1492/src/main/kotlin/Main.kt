//https://leetcode.com/problemset/all?search=1492
//https://leetcode.com/problems/the-kth-factor-of-n/
class Solution {
	fun kthFactor(n: Int, k: Int): Int {
		if (k > n) {
			return -1
		}
		val m = n / 2
		var j = 0
		var i  = 1
		while(i <= m) {
			if (n % i  == 0) {
				j += 1
			}
			if (j == k) {
				return i
			}
			i += 1
		}
		if (j == k - 1) {
			return n
		}
		return -1
	}
}
