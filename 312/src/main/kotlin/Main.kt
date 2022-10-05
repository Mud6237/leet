//https://leetcode.com/problemset/all?search=312
//https://leetcode.com/problems/burst-balloons/
import java.util.PriorityQueue
class Solution {
	fun swap(i: Int, j: Int, arr: MutableList<Int>) {
		val t = arr[i]
		arr[i] = arr[j]
		arr[j] = t
	}

	fun score(indexes: MutableList<Int>, nums: IntArray): Int {
		var coins = 0
		val picked = BooleanArray(nums.size)
		for(i in indexes) {
			var m = 1
			var j = i-1
			while(j >= 0 && picked[j]) {
				j -= 1
			}
			if (j >= 0) {
				m = nums[j]
			}
			val n = nums[i]
			var o = 1
			var k = i+1
			while(k < nums.size && picked[k]) {
				k += 1
			}
			if (k < nums.size) {
				o = nums[k]
			}
			coins += m * n * o
			picked[i] = true
		}
		return coins
	}
	
	fun maxCoinsImpl(
		k: Int,
		nums: IntArray,
		indexes: MutableList<Int>,
		res: IntArray
	) {
		if (k == nums.lastIndex) {
			res[0] = Math.max(res[0], score(indexes, nums))
			return
		}
		for(j in k until nums.size) {
			swap(j, k, indexes)
			maxCoinsImpl(k + 1, nums, indexes, res)
			swap(j, k, indexes)
		}
	}

	fun maxCoins_burteForce(nums: IntArray): Int {
		val res = IntArray(1, { Int.MIN_VALUE })
		val indexes = MutableList(nums.size, { it })
		maxCoinsImpl(0, nums, indexes, res)
		return res.first()
	}
	fun maxCoins1(nums: IntArray): Int {
		var coins = 0
		var nextNums = nums
		while(nextNums.size > 1) {
			var maxDiff = Int.MIN_VALUE
			var maxDiffIndex = -1
			for(i in 1 until nextNums.size) {
				val d = Math.abs(nextNums[i] - nextNums[i-1])
				if (d >= maxDiff) {
					if (maxDiff == d && maxDiffIndex >= 0) {
						if (nextNums[i-1] > nextNums[maxDiffIndex]) {
							maxDiffIndex = i-1
						}
					} else {
						maxDiffIndex = i-1
					}
					maxDiff = d
				}
			}
			val m = if (maxDiffIndex > 0) nextNums[maxDiffIndex-1] else 1
			val n = nextNums[maxDiffIndex]
			val o = if (maxDiffIndex < nextNums.lastIndex) nextNums[maxDiffIndex+1] else 1
			//println("m = $m n = $n o = $o")
			coins += m * n * o
			val next = IntArray(nextNums.size - 1)
			var j = 0
			for(i in 0 until maxDiffIndex) {
				next[j] = nextNums[i]
				j += 1
			}
			for(i in maxDiffIndex+1 until nextNums.size) {
				next[j] = nextNums[i]
				j += 1
			}
			//println("next = ${next.toList()}")
			nextNums = next
		}
		return if (nextNums.size > 0) {
			coins + nextNums.first()
		} else {
			coins
		}
	}

	private fun order(
		s: Array<IntArray>,
		i: Int,
		j: Int,
		result: MutableList<Int>,
	): Pair<Int, Int>  {
		println("order = $i, $j")
		if (i == j) {
			return (i-1 to i)
		}
		val p1 = order(s, i, s[i][j], result)
		val p2 = order(s, s[i][j] + 1, j, result)
		if (p1.second == p2.first) {
			result.add(p1.second)
		}
		return (p1.first to p2.second)
	}

	fun maxCoins(nums: IntArray): Int {
		val p = IntArray(nums.size + 2, { 1 })
		nums.copyInto(p, 1)
		val n = p.size - 1
		val m = Array(n + 1, { IntArray(n+1) })
		val s = Array(n + 1, { IntArray(n+1) })
		for(l in 2..n) {
			for(i in 1..n-l+1) {
				val j = i + l - 1
				m[i][j] = Int.MIN_VALUE
				for(k in i..j-1) {
					val q = m[i][k] + m[k+1][j] +  p[i-1] * p[k] * p[j]
					if( q > m[i][j]) {
						m[i][j] = q
						s[i][j] = k
					}
				}
			}
		}
		//m.forEach { println(it.toList())}
		//println()
		//s.forEach { println(it.toList()) }
		//val pickOrder = mutableListOf<Int>()
	 	//val finalOrder = order(s, 1, n, pickOrder)
		//pickOrder.add(finalOrder.first)
		//pickOrder.add(finalOrder.second)
		//println("score = ${score(pickOrder, p) - 2}")
		return m[1][n]
	}
}