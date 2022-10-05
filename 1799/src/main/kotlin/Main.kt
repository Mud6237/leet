// https://leetcode.com/problemset/all?search=1799
// https://leetcode.com/problems/maximize-score-after-n-operations/
import Solution

class Solution {
	companion object {
		tailrec fun gcd(a: Int, b: Int): Int {
			if (a == 0) {
				return b
			}
			if (b == 0) {
				return a
			}
			return gcd(b, a % b)
		}
		
		fun ByteArray.swap(x: Int, y:Int) {
			val t = this[x]
			this[x] = this[y]
			this[y] = t
		}

	}

	fun nextMask(mask: Int, i: Int, j: Int, n: Int) : Int {
		return mask or (1 shl (n-1-i)) or (1 shl (n-1-j))
	}
	
	private fun isVisited(mask: Int, i: Int,  n: Int): Boolean {
		val m = 1 shl (n - 1 - i)
		return (mask and m) == m
	}

	fun maxScoreImpl(i: Int, j: Int, score: Int, m: Array<IntArray>, mask: Int): Int {
		val ownScore = score * m[i][j]
		var s = ownScore
		val nm = nextMask(mask, i, j, m.size)
		for(x in 0..m.lastIndex) {
			if (isVisited(nm, x, m.size)) {
				continue
			}
			for(y in x+1..m.lastIndex) {
				if (isVisited(nm, y, m.size)) {
					continue
				}
				val nextScore = ownScore + maxScoreImpl(x, y, score + 1, m, nm)
				s = Math.max(s, nextScore)
			}
		}
		return s
	}

	fun maxScore(nums: IntArray): Int {
		val m = Array(nums.size, { IntArray(nums.size) })
		for(i in 0..nums.lastIndex) {
			for (j in (i+1)..nums.lastIndex) {
				m[i][j] = gcd(nums[i], nums[j])
			}
		}
		var s = 0
		for(i in 0..nums.lastIndex) {
			for (j in (i+1)..nums.lastIndex) {
				s = Math.max(s, maxScoreImpl(i, j, score = 1, m, mask = 0))
			}
		}
		return s
	}
}

fun main() {
	val nums = intArrayOf(1, 2)
	println(Solution().maxScore(nums))
}
