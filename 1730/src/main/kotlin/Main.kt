//https://leetcode.com/problems/shortest-path-to-get-food/
class Solution {
    fun getFood(grid: Array<CharArray>): Int {
        var queue = mutableListOf<Pair<Int, Int>>()
        outer@for((i, arr) in grid.withIndex()) {
            for((j, c) in arr.withIndex()) {
                if (c =='*') {
                    queue.add(i to j)
                    break@outer
                }
            }
        }
        var directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1),
            intArrayOf(-1, 0),
            intArrayOf(0, -1)
        )
        var path = 0
        while(queue.isNotEmpty()) {
            var queueSize = queue.size
            var nextQueue = mutableListOf<Pair<Int, Int>>()
            for(j in 0 until queueSize) {
                var pos = queue[j]
                var (x, y) = pos
                grid[x][y] = 'X'
                for(dir in directions) {
                    var p = x + dir.first()
                    var q = y + dir.last()
                    if (p >= 0 && p < grid.size && q >=0 && q < grid[p].size && grid[p][q] != 'X') {
                        nextQueue.add(p to q)
                        if (grid[p][q] == '#') {
                            return path + 1
                        }
                        grid[p][q] = 'X'
                    }
                }
            }
            queue = nextQueue
            path += 1
        }
        return -1
    }
}