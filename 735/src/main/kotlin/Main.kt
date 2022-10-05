//https://leetcode.com/problemset/all?search=735
//https://leetcode.com/problems/asteroid-collision/

class Solution {
	fun asteroidCollision(asteroids: IntArray): IntArray {
		val stack = mutableListOf<Int>()
		for(i in 0 until asteroids.size) {
			if (asteroids[i] < 0) {
				val a = Math.abs(asteroids[i])
				while(stack.isNotEmpty() && stack.last() > 0 && stack.last() < a) {
					stack.removeAt(stack.lastIndex)
				}
				if (stack.isNotEmpty()) {
					if (stack.last() == a) {
						stack.removeAt(stack.lastIndex)
					} else if(stack.last() < 0) {
						stack.add(asteroids[i])
					}
				} else {
					stack.add(asteroids[i])
				}
			} else {
				stack.add(asteroids[i])
			}
		}
		val result = IntArray(stack.size, { stack[it] })
		return result
	}
}

fun main() {
	//println(Solution().asteroidCollision(intArrayOf(5,10,-5)).toList())
	//println(Solution().asteroidCollision(intArrayOf(8, -8)).toList())
	//println(Solution().asteroidCollision(intArrayOf(10,2,-5)).toList())
	println(Solution().asteroidCollision(intArrayOf(-2,-1,1,2)).toList())
}
