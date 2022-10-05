//https://leetcode.com/problemset/all?search=829
//https://leetcode.com/problems/consecutive-numbers-sum/
//https://leetcode.com/problems/consecutive-numbers-sum/discuss/129015/5-lines-C++-solution-with-detailed-mathematical-explanation./816579
class Solution {
	fun consecutiveNumbersSum(n: Int): Int {
		var count = 0
		var s = 0
		for(k in 1..n) {
			//println(" $s ${(k * (k-1)) / 2}")
			//val r = n - (k * (k-1)) / 2
			val r = n - s
			s += k
			if (r <= 0) {
				break
			}
			if (r % k == 0) {
				count += 1
			}
		}
		return count
	}
}
fun main() {
	println("Hello World!")
}
