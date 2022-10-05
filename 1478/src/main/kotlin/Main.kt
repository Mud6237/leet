//https://leetcode.com/problems/allocate-mailboxes/
class Solution {
	fun minDistance(houses: IntArray, k: Int): Int {
		if (houses.size <= k) {
			return 0
		}
		houses.sort()
		val A = Array(k + 1, { Array(houses.size + 1, { IntArray(houses.size + 1) }) })
		for(i in 1..houses.size) {
			for(j in i+1..houses.size) {
				val count = (j - i) + 1
				val median = if (count % 2 == 0) {
					val x = (count - 1) / 2
					val y = count / 2
					(houses[i+x-1] + houses[i+y-1]) / 2.0
				} else {
					val x = count / 2
					(houses[i + x - 1]).toDouble()
				}
				var cost = 0.0
				for(z in i..j) {
					cost += Math.abs(median - houses[z-1])
				}
				A[1][i][j] = cost.toInt()
			}
		}
		//A[1].forEach { println(it.toList())}
		for(u in 2..k) {
			//println("u = $u")
			for(v in u+1..houses.size) {
				//println("outer slice = ${houses.slice(0..v-1)}")
				for(w in 1..(v-u)) {
					//println("inner slice = ${houses.slice(w-1..v-1)}")
					var m = Int.MAX_VALUE
					for(x in v downTo w+1) {
						//val rightSize = (v - x) + 1
						//val leftSize = fullSize - rightSize
						for(y in 1 until u) {
							val rightIndex = y
							val leftIndex = (u - y)
							//println("left = ${A[leftIndex][w][x-1]} right = ${A[rightIndex][x][w]}")
							m = Math.min(m, A[leftIndex][w][x-1] + A[rightIndex][x][v])
						}
						//println("left slice = ${houses.slice(0 until x-1)} right slice = ${houses.slice(x-1..v-1)}  m = $m loopCount = ${(1 until u).count()}")
					}
					A[u][w][v] = m
				}
			}
		}
		//A[k].forEach{ println(it.toList()) }
		//println()
		return A[k][1].last()
	}
}