//https://leetcode.com/problemset/all?search=1463
//https://leetcode.com/problems/cherry-pickup-ii/
class Solution {
	fun cherryPickup(grid: Array<IntArray>): Int {
		val m = grid.size
		val n = grid.first().size
		val directions = intArrayOf(
			-1,
			0,
			1
		)
		val dp = Array(m, { Array(n, { IntArray(n) } ) } )
		for(i in 0 until n) {
			for(j in 0 until n) {
				dp[m-1][i][j] = grid[m-1][i] + if (i == j) 0 else grid[m-1][j]
			}
		}
		for(z in m-2 downTo 0) {
			for(x in 0 until n) {
				for(y in 0 until n) {
					var r = grid[z][x] + if (x == y) 0 else grid[z][y]
					var q = 0
					for(dirX in directions) {
						val j = dirX + x
						for(dirY in directions) {
							val k = dirY + y
							if (j >= 0 && j < n && k >= 0 && k < n && j != k) {
								q = Math.max(q, dp[z+1][j][k])
							}
						}
					}
					dp[z][x][y] = r + q
				}
			}
		}
		return dp.first().first().last()
	}


	fun cherryPickup_wrong(grid: Array<IntArray>): Int {
		val directions = intArrayOf(
			-1,
			0,
			1
		)
		val m = grid.size
		val n = grid.first().size
		var green = grid.last().copyOf()
		var blue = grid.last().copyOf()
		for(i in m until n) {
			green[i] = 0
		}
		for(i in n-m-1 downTo 0) {
			blue[i] = 0
		}
		//println("inital blue = ${blue.toList()}")
		for(z in grid.lastIndex-1 downTo 0) {
			var maxBlue = -1
			var maxGreen = -1
			var maxBlueGreen = -1

			var maxBlueIndex = -1
			var maxNextBlueIndex = -1
			var maxGreenIndex = -1
			var maxNextGreenIndex = -1

			var gMaxColIndex = Math.min(z, n-1)
			var gNextMaxIndex = Math.min(z + 1, n-1)
			var bMinColIndex = Math.max(n-1-z, 0)
			val bNextMinColIndex = Math.max(n-1-(z+1), 0)
			val nextBlue = IntArray(n)
			val nextGreen = IntArray(n)
			//println("z = $z")
			for(gIndex in 0..gMaxColIndex) {
				val currentG = grid[z][gIndex]
				for(dir in directions) {
					val gNextIndex = gIndex + dir
					if (gNextIndex >= 0 && gNextIndex <= gNextMaxIndex) {
						val nextG = green[gNextIndex]
						////println("gIndex = $gIndex gNextIndex = $gNextIndex bMinColIndex = $bMinColIndex bNextMinColIndex = $bNextMinColIndex")
						var maxBlueForCurrentG = -1
						var maxBlueIndexForCurrentG = -1
						var maxNextBlueIndexForCurrentG = -1
						for(bIndex in n-1 downTo bMinColIndex) {
							val currentB = if (bIndex == gIndex) 0 else grid[z][bIndex]
							for(d in directions) {
								val bNextIndex = bIndex + d
								if (bNextIndex >= bNextMinColIndex && bNextIndex <= n-1 && bNextIndex != gNextIndex) {
									val nextB = blue[bNextIndex]
									////println("bIndex = $bIndex, bNextIndex = $bNextIndex, maxBlue = ${currentB + nextB}")
									if (currentB + nextB > maxBlueForCurrentG) {
										maxBlueForCurrentG = currentB + nextB
										maxBlueIndexForCurrentG = bIndex
										maxNextBlueIndexForCurrentG = bNextIndex
									}
									nextBlue[bIndex] = Math.max(nextBlue[bIndex], currentB + nextB)
								}
							}	
						}
						val maxCurrentG = currentG + nextG
						////println("maxCurrentG = $maxCurrentG, maxBlueForCurrentG = $maxBlueIndexForCurrentG nextBlue =${nextBlue.toList()}")
						nextGreen[gIndex] = Math.max(nextGreen[gIndex], maxCurrentG)
						if (maxCurrentG + maxBlueForCurrentG > maxBlueGreen) {
							maxGreenIndex = gIndex
							maxNextGreenIndex = gNextIndex
							maxBlueIndex = maxBlueIndexForCurrentG
							maxNextBlueIndex = maxNextBlueIndexForCurrentG
							maxBlue = maxBlueForCurrentG
							maxGreen = maxCurrentG
							maxBlueGreen = maxCurrentG + maxBlueForCurrentG
						}
					}
				}
			}
			//println("maxGreen = $maxGreen, maxGreenIndex = $maxGreenIndex maxNextGreenIndex = $maxNextGreenIndex nextGreen = ${nextGreen.toList()}")
			//println("maxBlue = $maxBlue, maxBlueIndex = $maxBlueIndex maxNextBlueIndex = $maxNextBlueIndex nextBlue = ${nextBlue.toList()}")
			green[maxNextBlueIndex] = 0
			blue[maxNextGreenIndex] = 0
			for(i in 0..gMaxColIndex) {
				val currentG = if (i == maxBlueIndex) 0 else grid[z][i]
				var maxCurrentG = -1
				for(dir in directions) {
					val gNextIndex = i + dir
					if (gNextIndex >= 0 && gNextIndex <= gNextMaxIndex) {
						val nextG = green[gNextIndex]
						maxCurrentG = Math.max(maxCurrentG, currentG + nextG)
					}
				}
				nextGreen[i] = maxCurrentG
			}
			for(i in n-1 downTo bMinColIndex) {
				val currentB = if (i == maxGreenIndex) 0 else grid[z][i]
				var maxCurrenB = -1
				for(dir in directions) {
					val bNextIndex = i + dir
					if (bNextIndex >= bNextMinColIndex && bNextIndex <= n-1) {
						val nextB = blue[bNextIndex]
						maxCurrenB = Math.max(maxCurrenB, nextB + currentB)
					}
				}
				nextBlue[i] = maxCurrenB
			}
			nextGreen[maxGreenIndex] = maxGreen
			nextBlue[maxBlueIndex] = maxBlue
			green = nextGreen
			blue = nextBlue
			//println("green = ${green.toList()}")
			//println("blue = ${blue.toList()}")
		}
		return green.first() + blue.last()
	}
}