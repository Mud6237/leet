//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
class Solution {
	fun maxProfit(prices: IntArray): Int {
		var profit = 0
		for(i in 1 until prices.size) {
			profit += Math.max(0, prices[i] - prices[i-1])
		}
		return profit
	}
}