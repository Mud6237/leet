// https://leetcode.com/problemset/all?search=188
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

class Solution {

	fun maxProfit(k: Int, prices: IntArray): Int {
		var buy = IntArray(k, { Int.MAX_VALUE })
		var profit = IntArray(k, { Int.MIN_VALUE })
		for(p in prices) {
			var pp = 0
			for(j in 0 until k) {
				buy[j] = Math.min(buy[j], p - pp)
				pp = Math.max(profit[j], p - buy[j])
				profit[j] = pp
			}

		}
		return profit.last()
	}
}


fun main(args: Array<String>) {
	println("Hello World!")
}
