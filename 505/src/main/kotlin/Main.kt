//https://leetcode.com/problems/the-maze-ii/
import java.util.PriorityQueue
class Solution {
    companion object {
        val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        fun isDirectionValid(pos: IntArray, dir: IntArray, maze: Array<IntArray>): Boolean {
            val x = pos.first() + dir.first()
            val y = pos.last() + dir.last()
            if (x >= 0 && x < maze.size && y >= 0 && y < maze[x].size) {
                return true
            }
            return false
        }

        fun areSame(pos: IntArray, dest: IntArray): Boolean {
            return pos.first() == dest.first() && pos.last() == dest.last()
        }

        fun nextPositionInDirection(currentPos: IntArray, dir: IntArray, maze: Array<IntArray>): Pair<IntArray, Int> {
            val nextPos = currentPos.copyOf()
            var dist = 0
            while(isDirectionValid(nextPos, dir, maze)) {
                var x = nextPos.first() + dir.first()
                var y = nextPos.last() + dir.last()
                if(maze[x][y] == 1) {
                    break
                }
                nextPos[0] = x
                nextPos[1] = y
                dist += 1
            }
            return Pair(nextPos, dist)
        }

    }

    fun shortestDistance(maze: Array<IntArray>, start: IntArray, destination: IntArray): Int {
        var queue = PriorityQueue<Pair<IntArray, Int>>{p1, p2 -> p1.second - p2.second }
        queue.offer(Pair(start, 0))
        while(queue.isNotEmpty()) {
            val nextQueue = PriorityQueue(queue.comparator())
            while(queue.isNotEmpty()) {
                val (currentPos, pathlength) = queue.poll()
                if (areSame(currentPos, destination)) {
                    return pathlength
                }
                maze[currentPos.first()][currentPos.last()] = 2
                for(dir in directions) {
                    if (!isDirectionValid(currentPos, dir, maze)) {
                        continue
                    }
                    val next = nextPositionInDirection(currentPos, dir, maze)
                    val nextPos = next.first
                    if (maze[nextPos.first()][nextPos.last()] != 0) {
                        continue
                    }
                    queue.offer(Pair(nextPos, pathlength + next.second))
                }
            }
            queue = nextQueue
        }
        return -1
    }
}
