// https://leetcode.com/problemset/all?search=805
// https://leetcode.com/problems/split-array-with-same-average/
// https://leetcode.com/problems/split-array-with-same-average/discuss/524407/C%2B%2B-solution-O(N*Sum)-DPsumbitmask-with-explanation
class Solution {
	data class StackState(
		var mask: Int,
		var depthIndex: Int,
		var breadthIndex: Int,
	)

	fun printGroups(mask: Int, nums: IntArray) {
		val group1 = mutableListOf<Int>()
		val group2 = mutableListOf<Int>()
		var n = nums.size
		for(i in 0 until n) {
			val m = 1 shl (n - 1 - i)
			if (mask and m == m) {
				group1.add(nums[i])
			} else {
				group2.add(nums[i])
			}
		}
		println("Group1: ${group1}, Group2: ${group2}")
	}

	fun isValidSplit(mask: Int, nums: IntArray): Boolean {
		//printGroups(mask, nums)
		var sum1 = 0
		var count1 = 0
		var sum2 = 0
		var count2 = 0
		var n = nums.size
		for(i in 0 until n) {
			val m = 1 shl (n - 1 - i)
			if (mask and m == m) {
				sum1 += nums[i]
				count1 += 1
			} else {
				sum2 += nums[i]
				count2 += 1
			}
		}
		return (sum1 / count1) == (sum2 / count2)
	}

	fun printStack(s: MutableList<StackState>) {
		s.reversed().forEach { println("Mask: ${it.mask.toString(2)} depthIndex: ${it.depthIndex} breadthIndex: ${it.breadthIndex}") }
	}

	fun splitArraySameAverage_bruteForce(nums: IntArray): Boolean {
		val stack = mutableListOf<StackState>()
		val n = nums.size
		val lastIndex = nums.lastIndex
		var mask1 = 0
		var mask2: Int
		for(i in 0 until lastIndex) {
			mask1 = mask1 or (1 shl (n - 1 - i))
			//println("mask1 ${mask1.toString(2)}")
			mask2 = mask1
			for(j in i + 1 until n) {
				//println("mask2 ${mask2.toString(2)} For [$i - $j] ")
				stack.add(StackState(mask2, depthIndex = j + 1, breadthIndex = j + 1))
				while(stack.isNotEmpty()) {
					//println("stack:")
					//printStack(stack)
					val (currentMask, currentDepthIndex, currentBreadthIndex) = stack.last()
					if (currentBreadthIndex > lastIndex) {
						stack.removeLast()
						if (currentDepthIndex > lastIndex && isValidSplit(currentMask, nums)) {
							return true
						}
					} else {
						val m = 1 shl (n - 1 - currentBreadthIndex)
						var newMask: Int
						if (currentMask and m == 0) {
							newMask = currentMask or m
							stack[stack.lastIndex].mask = newMask 
						} else {
							newMask = currentMask and (currentMask xor m)
							stack[stack.lastIndex].breadthIndex += 1
						}
						//println("Next mask is ${newMask.toString(2)}")
						stack.add(StackState(newMask, depthIndex = currentDepthIndex + 1, breadthIndex = currentBreadthIndex + 1))
					}
				}
				mask2 = mask2 or (1 shl (n - 1 - j))
			}
		}
		return false
	}

	fun splitArraySameAverage(nums: IntArray): Boolean {
		val S = nums.sum()
		val N = nums.size
		val dp = Array(N, { BooleanArray(S) })
		for(num in nums) {
			dp[1][num] = true
		}
		for(num in nums) {
			for(s in num until S) {
				for(len in 2 until N) {
					dp[len][s] = dp[len - 1][s - num]
				}
			}
		}
		//dp.forEach { println(it.toList())}
		for(len in 1 until N) {
			val d = len * S
			if (d % N == 0 && dp[len][d / N]) {
				return true
			}
		}
		return false
	}

}

fun main() {
	println(Solution().splitArraySameAverage((1..3).toList().toIntArray()))
	println(Solution().splitArraySameAverage((1..5).toList().toIntArray()))
	println(Solution().splitArraySameAverage(intArrayOf(3, 1)))
	println(Solution().splitArraySameAverage(intArrayOf(1, 1)))
	println(Solution().splitArraySameAverage((1..30).toList().toIntArray()))
	println(Solution().splitArraySameAverage(intArrayOf(16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 9000)))
}
