//https://leetcode.com/problemset/all?search=1648
import java.math.BigInteger
class Solution {
	companion object {
		val one = BigInteger("1")
		val two = BigInteger("2")
		val mod = BigInteger("1000000007")
		fun sumFrom(l: Int, h: Int):  Int {
			val low = BigInteger("$l")
			val high = BigInteger("$h")
			return high
					.multiply(high.add(one))
					.divide(two)
					.subtract(
						low.multiply(low.add(one))
						.divide(two)
					)
					.mod(mod)
					.toInt()
		}
		fun sum(a: Int, b: Int): Int {
			return BigInteger("$a").add(BigInteger("$b")).mod(mod).toInt()
		}
		fun mul(a: Int, b: Int): Int {
			return BigInteger("$a").multiply(BigInteger("$b")).mod(mod).toInt()
		}
	}
	fun maxProfit(inventory: IntArray, orders: Int): Int {
			val totalItems = inventory.size
			inventory.sortDescending()
			var totalOrdersPicked = 0
			var itemIndex = 1
			var previousItem = inventory.first()
			var totalProfit = 0
			while(totalOrdersPicked < orders && itemIndex <= totalItems) {
				var currentItem = if (itemIndex < totalItems) inventory[itemIndex] else 0
				var totalAvailableItems = (previousItem - currentItem) * itemIndex
				val totalAvailableOrders = orders - totalOrdersPicked
				var totalViableItems = Math.min(totalAvailableItems, totalAvailableOrders)
				val quotient = totalViableItems / itemIndex
				val remainder = totalViableItems % itemIndex
				val profit = sum(
					mul(sumFrom(previousItem - quotient, previousItem), itemIndex),
					mul(previousItem - quotient, remainder)
				)
				totalProfit = sum(totalProfit, profit)
				itemIndex += 1
				previousItem = currentItem
				totalOrdersPicked += totalViableItems
			}
			return totalProfit;
	}
}

fun main() {
	println(Solution().maxProfit(intArrayOf(2, 5), 4))
	println(Solution().maxProfit(intArrayOf(3, 5), 6))
	println(Solution().maxProfit(intArrayOf(1000000000), 1000000000))
	println(Solution().maxProfit(intArrayOf(2,8,4,10,6), 20))
	println(Solution().maxProfit(intArrayOf(497978859,167261111,483575207,591815159),836556809) == 373219333)
}
