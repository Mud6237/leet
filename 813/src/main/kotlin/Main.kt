//https://leetcode.com/problems/largest-sum-of-averages/
class Solution {
	fun largestSumOfAverages(nums: IntArray, k: Int): Double {
		val n = nums.size + 1
		val dp = Array(k, {Array(nums.size + 1, { DoubleArray(nums.size + 1) })})
		val sums = DoubleArray(nums.size + 1)
		for(i in 1 until sums.size) {
			sums[i] += sums[i-1] + nums[i-1].toFloat()
		}
		for(y in 1..nums.size) {
			for(z in y..nums.size) {
				var c = (z - y) + 1
				dp[0][y][z] = (sums[z] - sums[y-1]) / c
			}
		}
		//dp.first().forEach { println(it.toList())}
		//println()
		for(u in 1..k-1) { // partition size
			//println("k = $u")
			for(sbegin in 1 until n) {
				for(x in sbegin until n-u) {
					//println("Outer slice = ${nums.slice(x-1 until nums.size)}")
					for(y in x+u until n) {
						//println("Full inner slice = ${nums.slice(x-1..y-1)}")
						val fullSize = (x-1..y-1).count()
						var m = Double.MIN_VALUE
						for(z in y downTo x+1) {
							val rightSize = (z-1..y-1).count()
							val leftSize = fullSize - rightSize
							val cend = Math.min(rightSize, u)
							val cbegin = Math.max((leftSize - u) * -1, 0)
							for(cindex in cbegin until cend) {
								val rightIndex = cindex
								val leftIndex = u-1-cindex
								val cd = dp[leftIndex][x][z-1] + dp[rightIndex][z][y]
								m = Math.max(m, cd)
							}
							//println("right slice = ${nums.slice(z-1..y-1)} left slice = ${nums.slice(x-1..z-2)} rightSize = $rightSize, leftSize = $leftSize, fullSize =$fullSize cend = $cend, cbegin = $cbegin")
						}
						dp[u][x][y] = m
					}
					break
				}
				break
			}
			//dp[u].forEach { println(it.toList())}
			//println()
		}
		var r = Double.MIN_VALUE
		for(d in dp) {
			r = Math.max(r, d[1].last())
		}
		return r.toDouble()
	}
}
