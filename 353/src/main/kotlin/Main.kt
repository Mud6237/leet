class SnakeGame(val width: Int, val height: Int, val food: Array<IntArray>) {
	var snake = ArrayDeque<Pair<Int, Int>>()
	var foodIndex = 0
	init {
		snake.addLast(0 to 0)
	}

	private fun nextPosition(direction: String): Pair<Int, Int> {
		val head = snake.last()
		return when(direction) {
			"L" -> head.first to head.second - 1
			"R" -> head.first to head.second + 1
			"D" -> head.first + 1 to head.second
			else -> head.first - 1 to head.second
		}
	}

	private fun hasFood(pos: Pair<Int, Int>): Boolean {
		if (foodIndex >= food.size) {
			return false
		}
		var nextFood = food[foodIndex]
		return nextFood[0] == pos.first && nextFood[1] == pos.second
	}

	private fun isWall(pos: Pair<Int, Int>): Boolean {
		if (pos.first >= 0 && pos.first < height && pos.second >= 0 && pos.second < width) {
			return false
		}
		return true
	}

	private fun crossesSelf(pos: Pair<Int, Int>): Boolean {
		if (snake.size > 3) {
			for(p in snake) {
				if(p.first == pos.first && p.second == pos.second) {
					return true
				}
			}
		}
		return false
	}

	fun move(direction: String): Int {
		val nextPos = nextPosition(direction)
		if (isWall(nextPos)) {
			return -1
		}
		if (!hasFood(nextPos)) {
			snake.removeFirst()
		} else {
			foodIndex += 1
		}
		if (crossesSelf(nextPos)) {
			//println("crosses self nextPos = ${nextPos}")
			return -1
		}
		snake.addLast(nextPos)
		//println("direction = ${direction} Food Index = ${foodIndex} Snake: ")
		//println(snake)
		return foodIndex
	}
}
