// https://leetcode.com/problemset/all?search=675
// https://leetcode.com/problems/cut-off-trees-for-golf-event/

// https://leetcode.com/problems/cut-off-trees-for-golf-event/discuss/148729/Logical-Thinking-with-Java-Code-Beats-98.04

class Solution {

	data class TreeInfo(
		val x: Int,
		val y: Int,
		val v: Int
	)

	private fun getAllTreeHeights(forest: List<List<Int>>): MutableList<TreeInfo> {
		val result = mutableListOf<TreeInfo>()
		for(i in 0..forest.lastIndex) {
			for(j in 0..forest.first().lastIndex) {
				if (forest[i][j] > 1) {
					result.add(TreeInfo(i, j, forest[i][j]))
				}
			}
		}
		return result
	}

	private fun getStepsCount(forest: List<List<Int>>, srcX: Int, srcY:Int, destX: Int, destY: Int): Int {
		val visited = Array<Array<Boolean>>(forest.size, { Array(forest.first().size, { false }) })
		val queue = ArrayDeque<IntArray>()
		queue.addLast(intArrayOf(srcX, srcY))
		visited[srcX][srcY] = true
		var steps = 0
		while(queue.isNotEmpty()) {
			repeat(queue.size) {
				val head = queue.removeFirst()
				val (x, y) = head
				if (x == destX && y == destY) {
					return steps
				}
				// top
				if (x > 0 && !visited[x-1][y] && forest[x-1][y] > 0  ) {
					queue.addLast(intArrayOf(x-1, y))
					visited[x-1][y] = true
				}
				// down
				if (x < forest.lastIndex && !visited[x+1][y] && forest[x+1][y] > 0  ) {
					queue.addLast(intArrayOf(x+1, y))
					visited[x+1][y] = true
				}
				// left 
				if (y > 0 && !visited[x][y-1] && forest[x][y-1] > 0  ) {
					queue.addLast(intArrayOf(x, y-1))
					visited[x][y-1] = true
				}
				// right 
				if (y < forest[x].lastIndex && !visited[x][y+1] && forest[x][y+1] > 0  ) {
					queue.addLast(intArrayOf(x, y+1))
					visited[x][y+1] = true
				}
			}
			steps += 1
		}
		return -1
	}

	fun cutOffTree(forest: List<List<Int>>): Int {
			val treeHeights = getAllTreeHeights(forest)
			treeHeights.sortWith{ info1, info2 -> info1.v - info2.v }
			var x = 0
			var y = 0
			var totalSteps = 0
			for(treeInfo in treeHeights) {
				val steps = getStepsCount(forest, x, y, treeInfo.x, treeInfo.y)
				if (steps < 0) {
					return -1
				}
				totalSteps += steps
				x = treeInfo.x
				y = treeInfo.y
			}
			return totalSteps
	}

}

fun main(args: Array<String>) {
	val forest = listOf(listOf(1,2,3),listOf(0,0,4),listOf(7,6,5))
	val expected = 6
	val actual = Solution().cutOffTree(forest)
	println(actual)
}
