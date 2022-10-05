// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/?currentPage=1&orderBy=most_votes&query=

class Solution {
	fun maxProfit(prices: IntArray): Int {
		// If only 1 transaction was allowed
		// we want to buy at the loweset possible price and sell at the 
		// highest possible price
		var t1BuyPrice: Int  = Int.MAX_VALUE
		var t2BuyPrice: Int  = Int.MAX_VALUE
		var t1Profit = Int.MIN_VALUE
		var t2Profit = Int.MIN_VALUE
		for(price in prices) {
			t1BuyPrice = Math.min(t1BuyPrice, price)
			t1Profit = Math.max(t1Profit, price - t1BuyPrice)
			t2BuyPrice = Math.min(t2BuyPrice, price - t1Profit)
			t2Profit = Math.max(t2Profit, price - t2BuyPrice)
		}
		return t2Profit
	}
}


fun main(args: Array<String>) {
	 println(Solution().maxProfit(intArrayOf(7,6,4,3,1)))
	 println(Solution().maxProfit(intArrayOf(1)))
	 println(Solution().maxProfit(intArrayOf(1,2,3,4,5)))
 }
