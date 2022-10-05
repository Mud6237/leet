// https://leetcode.com/problemset/all?search=403
// https://leetcode.com/problems/frog-jump/discuss/88824/Very-easy-to-understand-JAVA-solution-with-explanations
class Solution {
	fun canCross_bruteForce(stones: IntArray): Boolean {
		val stack = mutableListOf(Triple(1, 1, 1))
		while(stack.isNotEmpty()) {
			val (x, y, z) = stack.removeLast()
			if (z == stones.last()) {
				return true
			}
			for(i in (x+1) until stones.size) {
				if(stones[i] >= stones[x] + y - 1 && stones[i] <= stones[x] + y + 1) {
					stack.add(Triple(i, stones[i] - stones[x], stones[i] - stones[x] + z))
				}
			}
		}
		return false
	}
	fun canCross(stones: IntArray): Boolean {
		if (stones.isEmpty()) {
			return false
		}
		val m = hashMapOf<Int, HashSet<Int>>(0 to hashSetOf(1))
		for(i in 1..stones.lastIndex) {
			m[stones[i]] = hashSetOf<Int>()
		}
		for(i in 0..stones.lastIndex - 1) {
			val stone = stones[i]
			val strides = m.get(stone) ?: continue
			for(stride in strides) {
				val reach = stone + stride
				if (reach == stones.last()) {
					return true
				}
				val s = m.get(reach) ?: continue
				if (stride - 1 > 0) {
					s.add(stride - 1)
				}
				s.add(stride)
				s.add(stride+1)

			}
		}
		return false
	}
}

fun main(args: Array<String>) {
	val stones = intArrayOf(0,1,3,5,6,8,12,17)
	val expected = false
	println(Solution().canCross(stones))
}
