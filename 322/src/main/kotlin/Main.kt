//https://leetcode.com/problems/coin-change/
class Solution {
	fun coinChange(coins: IntArray, amount: Int): Int {
		if (amount < 1) {
			return 0
		}
		var minCoin = Int.MAX_VALUE
		var amountArr = IntArray(amount + 1, { -1 })
		amountArr[0] = 0
		for(c in coins) {
			if (c <= amount) {
				if (c == amount) {
					return 1
				}
				amountArr[c] = 1
			}
			minCoin = Math.min(minCoin, c)
		}
		if (amount < minCoin) {
			return -1
		}
		for(a in minCoin+1..amount) {
			var m = Int.MAX_VALUE
			for(c in coins) {
				var d = a - c
				if(d >= 0  && amountArr[d] >= 0) {
					m = Math.min(m, amountArr[d] + 1)
				}
			}
			if (m != Int.MAX_VALUE) {
				amountArr[a] = m
			}
		}
		return amountArr[amount]
	}
}