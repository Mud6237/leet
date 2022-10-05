//https://leetcode.com/problemset/all?search=174
//https://leetcode.com/problems/dungeon-game/

class Solution {
	fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
		var m = dungeon.lastIndex
		var n = dungeon.last().lastIndex
		var p = Array(dungeon.size, { dungeon[it].copyOf() })
		val b = Array(dungeon.size, { BooleanArray(dungeon[it].size) })
		b[m][n] = dungeon.last().last() <= 0
		for(i in n-1 downTo 0) {
			var v = dungeon[m][i]
			var w = p[m][i+1]
			p[m][i] = Math.min(Math.min(v + w, v), 0)
			b[m][i] = v < 0 || b[m][i+1]
		}
		for(i in m-1 downTo 0) {
			var k = dungeon[i].lastIndex
			val v = dungeon[i][k]
			val w = p[i+1].last()
			p[i][k] = Math.min(Math.min(v+w, v), 0)
			b[i][k] = v < 0 || b[i+1].last()
		}
		for(i in m-1 downTo 0) {
			n = dungeon[i].lastIndex
			for(j in n-1 downTo 0) {
				val u = dungeon[i][j]
				val v = p[i+1][j]
				val w = p[i][j+1]
				val q = if ((u + v) > (u + w)) b[i+1][j] else b[i][j+1]
				p[i][j] = Math.min(Math.min(u, Math.max(u + v, u + w)), 0)
				b[i][j] = u < 0 || q
			}
		}
		var r = p.first().first() * -1
		if (b.first().first()) {
			r += 1
		}
		return Math.max(r, 1)
	}
}