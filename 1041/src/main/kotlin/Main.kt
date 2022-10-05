//https://leetcode.com/problemset/all?search=1041
// https://leetcode.com/problems/robot-bounded-in-circle/

class Solution {
	companion object {
		fun nextHeading(currentHeading: Int, c: Char): Int {
			return when(c) {
				'L' -> (currentHeading + 90) % 360
				'R' -> (currentHeading + 270) % 360
				else -> currentHeading
			}
		}
		fun nextPoint(currentPoint: Pair<Int, Int>, currentHeading: Int, c: Char): Pair<Int, Int> {
			if (c != 'G') {
				return currentPoint
			}
			return when(currentHeading) {
				90 -> Pair(currentPoint.first - 1, currentPoint.second)
				180 -> Pair(currentPoint.first, currentPoint.second - 1)
				270 -> Pair(currentPoint.first + 1, currentPoint.second)
				else -> Pair(currentPoint.first, currentPoint.second + 1)
			}
		}
	}
	fun isRobotBounded(instructions: String): Boolean {
		val initialPosition = Pair(0, 0)
		val initialHeading = 0
		var pos = initialPosition
		var heading = initialHeading
		for(c in instructions) {
			pos = nextPoint(pos, heading, c)
			heading = nextHeading(heading, c)
		}
		return pos == initialPosition || heading != initialHeading
	}
}
fun main() {
	println(Solution().isRobotBounded("GGLLGG"))
	println(Solution().isRobotBounded("GG"))
	println(Solution().isRobotBounded("GL"))
}
