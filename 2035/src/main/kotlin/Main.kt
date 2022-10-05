//https://leetcode.com/problemset/all?search=2035
//https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/

import java.util.TreeSet

class Solution {
	private fun minimumDifferenceImpl(
		count: Int,
		k: Int,
		nums: IntArray,
		n: Int,
		currentSum: Int,
		totalSum: Int,
		res: IntArray
	){
		if (count == n) {
			val otherSum = totalSum - currentSum
			res[0] = Math.min(res[0], Math.abs(currentSum - otherSum))
			return
		}
		for(j in k until nums.size) {
			minimumDifferenceImpl(count+1, j+1, nums, n, currentSum + nums[j], totalSum, res)
		}
	}

	fun minimumDifference_bruteForce1(nums: IntArray): Int {
		val res = intArrayOf(Int.MAX_VALUE)
		val totalSum = nums.sum()
		val currentSum = 0
		val startIndex = 0
		val n = nums.size / 2
		var count = 0
		minimumDifferenceImpl(count, startIndex, nums, n, currentSum, totalSum, res)
		return res.first()
	}

	private fun subArraySums(nums: List<Int>): Array<MutableList<Int>> {
		val a = Array(nums.size + 1, { mutableListOf<Int>()})
		a[0].add(0)
		for(i in 0 until nums.size) {
			for(j in i+1 downTo 2) {
				for(z in a[j-1]) {
					a[j].add(z + nums[i])
				}
			}
			a[1].add(nums[i])
		}
		return a
	}

	fun minimumDifference(nums: IntArray): Int {
		val n = nums.size / 2
		val totalSum = nums.sum()
		val targetSum = totalSum / 2
		val left = subArraySums(nums.slice(0 until n))
		val right = subArraySums(nums.slice(n until nums.size))
		var mSum = Int.MAX_VALUE
		var minZ = Int.MAX_VALUE
		for(j in 0 until left.size) {
			val k = (n - j)
			val rSet = TreeSet<Int>().apply {
				addAll(right[k])
			}
			//println("targetsum = $targetSum rSet = $rSet")
			for(x in left[j]) {
				val a = rSet.floor(targetSum - x) ?: rSet.ceiling(targetSum - x)
				val z = x + a
				val mz = Math.abs(targetSum - z)
				if (mz < minZ) {
					minZ = mz
					mSum = z
				}
				//println("x = $x delta = ${targetSum - x} a = $a")
			}
		}
		val otherSum = totalSum - mSum
		return Math.abs(mSum - otherSum)
	}
}