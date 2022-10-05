// https://leetcode.com/problems/number-of-islands-ii/
class Solution {
	fun numIslands2(m: Int, n: Int, positions: Array<IntArray>): List<Int> {
		val h = hashMapOf<Pair<Int, Int>, Int>()
		val stack = mutableListOf<Pair<Int, Int>>()
		var count = mutableListOf<Int>()
		val directions = arrayOf(Pair(0, 1), Pair(1, 0), Pair(-1, 0), Pair(0, -1))
		for((index, pos) in positions.withIndex()) {
			val pp = Pair(pos[0], pos[1])
			var c = 0
			h[pp] = index - 1
			for(i in 0..index) {
				val e = Pair(positions[i][0], positions[i][1])
				if (h.getOrDefault(e, index) < index) {
					c += 1
					stack.add(e)
				}
				while(stack.isNotEmpty()) {
					var t = stack.last()
					l@while(true) {
						h[t] = index
						for(d in directions) {
							val p = Pair(t.first + d.first, t.second + d.second)
							if (p.first < m && p.first >=0 && p.second < n && p.second >=0 && h.getOrDefault(p, index) < index) {
								stack.add(p)
								t = p
								continue@l
							}
						}
						break
					}
					stack.removeLast()
				}
			}
			count.add(c)
		}
		return count
	}
}
fun main() {
	val positions = arrayOf(intArrayOf(0,0), intArrayOf(0,1), intArrayOf(1,2), intArrayOf(2,1))
	val m = 3
	val n = 3
	println(Solution().numIslands2(m, n, positions))
}
