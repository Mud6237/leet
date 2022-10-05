// https://leetcode.com/problems/robot-room-cleaner/
/**
 * // This is the Robot's API interface.
 * // You should not implement it, or speculate about its implementation
 */

class Robot (val p: IntArray, val board: Array<IntArray>, var heading: Int = 0) {
    companion object {
        val right = intArrayOf(0, 1)
        val left = intArrayOf(0, -1)
        val up = intArrayOf(-1, 0)
        val down = intArrayOf(1, 0)
    }

    var nextMoveDir: IntArray = intArrayOf(0, 0)

    fun nextMoveDirection() : IntArray {
        val dir: IntArray
        if (heading == 0) {
            dir = right
        } else if (heading == 90) {
            dir = down
        } else if (heading == 180) {
            dir = left
        } else {
            dir = up
        }
        return dir
    }
    
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    fun move(): Boolean {
        val dir = nextMoveDirection()
        val x = p[0] + dir[0]
        val y = p[1] + dir[1]
        if (x >=0 && x < board.size && y >=0 && y < board[x].size && board[x][y] >= 1) {
            p[0] = x
            p[1] = y
            return true
        }
        return false
    }

    fun nextHeading(h: Int, v: Int): Int {
        return (h + v) % 360
    }

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    fun turnLeft() {
        turnRight()
        turnRight()
        turnRight()
    }

    fun turnRight() {
        heading = nextHeading(heading, 90)
    }

    // Clean the current cell.
    fun clean() {
        val (x, y) = p
        board[x][y] = 2
    }
    override fun toString() : String {
        val sb = StringBuilder()
        sb.append("Position: ${p.toList()} \n")
        sb.append("Heading: ${heading} \n")
        sb.append("Board: \n")
        board.forEach { sb.append(it.toList().toString(), "\n") }
        return sb.toString()
    }
}


class Solution {

    companion object {
        val right = intArrayOf(0, 1)
        val left = intArrayOf(0, -1)
        val top = intArrayOf(-1, 0)
        val down = intArrayOf(1, 0)
    }

    data class Position(
        val i: Int,
        val j: Int,
    )

    fun nextHeading(heading: Int, turn: Int): Int {
        return (heading + turn) % 360
    }


    fun nextPosition(p: Position, heading: Int): Position {
        if (heading == 90) {
            return Position(p.i + 1, p.j)
        } else if (heading == 180) {
            return Position(p.i, p.j - 1)
        } else if (heading == 270) {
            return Position(p.i - 1, p.j)
        } else {
            return Position(p.i, p.j + 1)
        }
    }

    fun cleanRoomImpl(robot: Robot, p: Position, heading: Int, visited: HashSet<Position>) {
        robot.clean()
        //println(robot)
        // 90 deg
        //println("Position ${p} heading ${heading}: Robot position ${robot.p.toList()} heading: ${robot.heading}")
        val initialPosition = Position(robot.p[0], robot.p[1])
        val initialHeading = robot.heading
        visited.add(p)
        robot.turnRight()
        var newPosition = nextPosition(p, nextHeading(heading, 90))
        if (!visited.contains(newPosition) && robot.move()) {
            cleanRoomImpl(robot, newPosition, nextHeading(heading, 90), visited)
            robot.turnLeft()
            robot.turnLeft()
            robot.move()
            robot.turnRight()
        } else {
            //println("Already visited position $newPosition ")
            robot.turnLeft()
        }
        // 180 deg
        var sb = StringBuilder()
        sb.append("Intial $initialPosition Current Position ${robot.p.toList()} Intial Heading: $initialHeading Current heading: ${robot.heading} 90 Deg Position = $newPosition")
        newPosition = nextPosition(p, nextHeading(heading, 180))
        sb.append(" 180 Deg position = $newPosition")
        if (!visited.contains(newPosition)) {
            robot.turnRight()
            robot.turnRight()
            if(robot.move()) {
                cleanRoomImpl(robot, newPosition, nextHeading(heading, 180), visited)
                robot.turnRight()
                robot.turnRight()
                robot.move()
            } else {
                robot.turnRight()
                robot.turnRight()
            }
        }
        newPosition = nextPosition(p, nextHeading(heading, 270))
        sb.append("270 Deg position = $newPosition")
        if (!visited.contains(newPosition)) {
            robot.turnLeft()
            if (robot.move()) {
                cleanRoomImpl(robot, newPosition, nextHeading(heading, 270), visited)
                robot.turnRight()
                robot.turnRight()
                robot.move()
                robot.turnLeft()
            } else {
                robot.turnRight()
            }
        }
        newPosition = nextPosition(p, nextHeading(heading, 360))
        sb.append(" 360 Deg position = $newPosition")
        if (!visited.contains(newPosition)) {
            if (robot.move()) {
                cleanRoomImpl(robot, newPosition, nextHeading(heading, 360), visited)
                robot.turnRight()
                robot.turnRight()
                robot.move()
                robot.turnRight()
                robot.turnRight()
            }
        }
        //println(sb.toString())
    }

    fun cleanRoom(robot: Robot) {
        val visited = HashSet<Position>()
        cleanRoomImpl(robot, Position(0,0), 0, visited)
        println(robot)
    }
}
fun main() {
	val board = arrayOf(intArrayOf(1,1,1,1,1,0,1,1),intArrayOf(1,1,1,1,1,0,1,1),intArrayOf(1,0,1,1,1,1,1,1),intArrayOf(0,0,0,1,0,0,0,0),intArrayOf(1,1,1,1,1,1,1,1))
    val pos = intArrayOf(1, 3)
    val robot = Robot(pos, board)
    Solution().cleanRoom(robot)
    //println(robot)
}

