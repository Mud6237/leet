// https://leetcode.com/problemset/all?search=711
class Solution {
	private fun traverse(grid: Array<IntArray>, i: Int, j: Int, sb: StringBuilder) {
		val v = grid[i][j]
		grid[i][j] = 2
		if (i > 0 && grid[i-1][j] == 1) {
			sb.append("U")
			traverse(grid, i-1, j, sb)
			sb.append("B")
		}
		if (i < grid.lastIndex && grid[i+1][j] == 1) {
			sb.append("D")
			traverse(grid, i+1, j, sb)
			sb.append("B")
		}
		if (j > 0 && grid[i][j-1] == 1) {
			sb.append("L")
			traverse(grid, i, j-1, sb)
			sb.append("B")
		}
		if (j < grid[i].lastIndex && grid[i][j+1] == 1) {
			sb.append("R")
			traverse(grid, i, j+1, sb)
			sb.append("B")
		}
	}

	fun getMaxHighAndLowIndex(i: Int, j: Int, sb: StringBuilder): Pair<Pair<Int, Int>, Pair<Int, Int>> {
		var u = i
		var v = j
		var x = Int.MIN_VALUE
		var y = Int.MIN_VALUE
		var m = i
		var n = j
		var p = ' '
		for(c in sb) {
			if (c == 'U') {
				m -= 1
			} else if (c == 'D') {
				m += 1
			} else if (c == 'R') {
				n +=1
			} else if (c == 'L') {
				n -= 1
			} else {
				if (p == 'U') {
					m += 1
				} else if (p == 'D') {
					m -= 1
				} else if (c == 'R') {
					n -=1
				} else if (c == 'L') {
					n += 1
				}
			}
			p = c
			u = Math.min(m, u)
			v = Math.min(n, v)
			x = Math.max(m, x)
			y = Math.max(n, y)
		}
		return Pair(Pair(u, v), Pair(x, y))
	}

	fun serialize(grid: Array<IntArray>, u: Int, v: Int, x: Int, y: Int, sb: StringBuilder): List<String> {
		// un-rotated
		val r = mutableListOf<String>()
		for(i in u..x) {
			for(j in v..y) {
				sb.append(grid[i][j])
			}
		}
		r.add(sb.toString())
		sb.clear()
		// rotate 90 and horizontal reflection
		for(j in v..y) {
			for(i in x downTo u) {
				sb.append(grid[i][j])
			}
		}
		r.add(sb.toString())
		sb.clear()
		// rotate 180
		for(i in x downTo u) {
			for(j in y downTo v) {
				sb.append(grid[i][j])
			}
		}
		r.add(sb.toString())
		sb.clear()
		// rotate 270 & vertical reflection
		for(j in y downTo v) {
			for(i in u..x) {
				sb.append(grid[i][j])
			}
		}
		r.add(sb.toString())
		return r
	}

	private fun printGrid(grid: Array<IntArray>) {
		for(p in grid) {
			println(p.toList())
		}
	}

	fun numDistinctIslands2(grid: Array<IntArray>): Int {
		val sb = StringBuilder()
		var count = 0
		val m = hashSetOf<String>()
		for(i in 0..grid.lastIndex) {
			for(j in 0..grid[i].lastIndex) {
				if (grid[i][j] == 1) {
					sb.clear()
					traverse(grid, i, j, sb)
					val p = getMaxHighAndLowIndex(i, j, sb)
					//println("Route ($i, $j) : ${sb.toString()} $p")
					sb.clear()
					val (u, v) = p.first
					val (x, y) = p.second
					val serializations = serialize(grid, u, v, x, y, sb)
					var found = false
					for(s in serializations) {
						if (m.contains(s)) {
							found = true
							break
						}
					} 
					if (!found) {
						count += 1
						m.addAll(serializations)
					}
				}
			}
		}
		return count
	}
}

fun main(args: Array<String>) {
	val grid = arrayOf(intArrayOf(1,1,0,0,0),intArrayOf(1,0,0,0,0),intArrayOf(0,0,0,0,1),intArrayOf(0,0,0,1,1))
	Solution().serialize(grid, 0, 0, 3, 2, StringBuilder())
	Solution().serialize(grid, 0, 0, 2, 2, StringBuilder())
	val expected = 1
	println(Solution().numDistinctIslands2(grid))
}
