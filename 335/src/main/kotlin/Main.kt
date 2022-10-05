//https://leetcode.com/problemset/all?search=335
//https://leetcode.com/problems/self-crossing/
//https://leetcode.com/problems/self-crossing/discuss/729133/How-to-explain-to-interviewer-335.-Self-Crossing

class Solution {
	data class Point(val x: Int, val y: Int)
	data class Line(val a: Point, val b: Point)

	companion object {
		fun intersect(verticalLine: Line, horizontalLine: Line): Boolean {
			val ax = verticalLine.a.x - verticalLine.b.x
			val bx = horizontalLine.a.x - horizontalLine.b.x
			val ay = verticalLine.a.y - verticalLine.b.y
			val by = horizontalLine.a.y - horizontalLine.b.y
			val c = ax * by - bx * ay
			if ( c == 0 ) {
				return false
			}
			//return true
			val a = verticalLine.a.x * verticalLine.b.y - verticalLine.a.y * verticalLine.b.x
			val b = horizontalLine.a.x * horizontalLine.b.y - horizontalLine.a.y * horizontalLine.b.x
			val x = (a * bx - b * ax) / c
			//val y = (a * by - b * ay) / c
			return x > Math.min(horizontalLine.a.x, horizontalLine.b.x) && x < Math.max(horizontalLine.a.x, horizontalLine.b.x)
		}
	}
	fun isSelfCrossing_bruteForce_incorrect(distance: IntArray): Boolean {
		var prev = Point(0, 0)
		var directions = arrayOf(intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(1, 0))
		val yAxisComparator = Comparator<Line>{ line1, line2 ->
			val ay = Math.min(line1.a.y, line1.b.y)
			val by = Math.min(line2.a.y, line2.b.y)
			ay - by
		}
		val xAxisComparator = Comparator<Line>{ line1, line2 ->
			val ax = Math.min(line1.a.x, line1.b.x)
			val bx = Math.min(line2.a.x, line2.b.x)
			ax - bx
		}
		val verticalLines = mutableListOf<Line>()
		val horizontalLines = mutableListOf<Line>()
		val lines = arrayOf(verticalLines, horizontalLines)
		for((i, d) in distance.withIndex()) {
			val dir = directions[i % 4]
			val newPoint = Point(prev.x + dir[0] * d, prev.y + dir[1] * d)
			val lineList = lines[i % lines.size]
			val newLine = Line(a = prev, b = newPoint)
			lineList.add(newLine)
			prev = newPoint
		}
		verticalLines.sortWith(xAxisComparator)
		horizontalLines.sortWith(yAxisComparator)
		//println(verticalLines)
		//println(horizontalLines)
		for(horizontalLine in horizontalLines) {
			for(verticalLine in verticalLines) {
				if (intersect(verticalLine, horizontalLine)) {
					return true
				}
			}
		}
		return false
	}
	fun isSelfCrossing(distance: IntArray): Boolean { 
		/*             i-2
    case 1 : i-1┌─┐
                └─┼─> i
                	 i-3
                 
                    i-2
    case 2 : i-1 ┌────┐
                 └─══>┘i-3
                 i  i-4      (i overlapped i-4)

    case 3 :    i-4
               ┌──┐ 
               │i<┼─┐
            i-3│ i-5│i-1
               └────┘
                i-2
		*/
		for(i in 3 until distance.size) {
			if (distance[i] >= distance[i-2] && distance[i-1] <= distance[i-3]) {
				// case 1: 4th line crosses/touches the first line
				return true
			} else if (i >= 4 && distance[i] + distance[i-4] >= distance[i-2] && distance[i-1] == distance[i-3]) {
				// case 2: 3rd line overshoots the first line and fifth line crosses/touches first line
				return true
			} else if (i >= 5 && distance[i-2] >= distance[i-4] && distance[i] + distance[i-4] >= distance[i-2] && distance[i-1] <= distance[i-3] && distance[i-5] + distance[i-1] >= distance[i-3]) {
				// case 3: 4th line 
				return true
			}
		}
		return false
	}
}
fun main() {
	var distance = intArrayOf(1, 2, 3, 4)
	println(Solution().isSelfCrossing(distance))
	distance = intArrayOf(2, 1, 1, 2)
	println(Solution().isSelfCrossing(distance))
	distance = intArrayOf(1, 1, 1, 1)
	println(Solution().isSelfCrossing(distance))
}
