//https://leetcode.com/problemset/all?search=2104
//https://leetcode.com/problems/sum-of-subarray-ranges/
import java.math.BigInteger

class Solution {
	companion object {
		fun mul(a: Int,b: Int): Long {
			return ((a % Long.MAX_VALUE) * (b % Long.MAX_VALUE)) % Long.MAX_VALUE
			//return BigInteger("$a").multiply(BigInteger("$b")).toLong()
		}
	}
	fun subArrayRanges(nums: IntArray): Long {
		val less = IntArray(nums.size)
		val greater = IntArray(nums.size)
		val lessStack = mutableListOf<Int>()
		val greaterStack = mutableListOf<Int>()
		for((index, num) in nums.withIndex()) {
			while(lessStack.isNotEmpty() && nums[lessStack.last()] >= num) {
				lessStack.removeAt(lessStack.lastIndex)
			}
			while(greaterStack.isNotEmpty() && nums[greaterStack.last()] <= num) {
				greaterStack.removeAt(greaterStack.lastIndex)
			}
			less[index] = if (lessStack.isEmpty()) -1 else lessStack.last()
			greater[index] = if (greaterStack.isEmpty()) -1 else greaterStack.last()
			lessStack.add(index)
			greaterStack.add(index)
		}
		var lessSum = LongArray(nums.size)
		var greaterSum = LongArray(nums.size)
		var res = 0L
		for((index, num) in nums.withIndex()) {
			var r = less[index]
			if (r >= 0) {
				lessSum[index] = lessSum[r] + mul((index - r),  num)
			} else {
				lessSum[index] = mul(index+1, num)
			}
			r = greater[index]
			if (r >= 0) {
				greaterSum[index] = greaterSum[r] + mul((index - r), num)
			} else {
				greaterSum[index] = mul(index+1, num)
			}
			//println("For num=${num} gr =${r} g=${greaterSum[index]} l = ${lessSum[index]} res = ${greaterSum[index] - lessSum[index]} ")
			res += greaterSum[index] - lessSum[index]
		}
		return res
	}
}