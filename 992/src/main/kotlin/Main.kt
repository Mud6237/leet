// https://leetcode.com/problemset/all?search=992
// https://leetcode.com/problems/subarrays-with-k-different-integers/

class Solution {
	fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
		val m = hashMapOf<Int, Int>()
		var c = 0
		for(n in nums) {
			val a = m.getOrDefault(n, 0) + 1
			c+= if (a==1) 1 else 0 
			m[n] = a
		}
		var p = c
		var tc = 0
		for(i in 0..nums.lastIndex) {
			val nc = if (i > 0) {
				m[nums[i-1]] = m.getOrDefault(nums[i-1], 1) - 1 
				val o = if(m[nums[i-1]] == 0) -1 else 0
				p + o
			} else {
				p
			}
			var ic = nc
			tc += if (ic == k) 1 else 0
			//println("SubArray ${nums.slice(i..nums.lastIndex).toList()} count= $nc total=$tc")
			val l = Math.max(nums.lastIndex - 1 - k, i)
			for(j in (nums.lastIndex - 1) downTo l) {
				m[nums[j+1]] = m.getOrDefault(nums[j+1], 1) - 1
				val o = if (m[nums[j+1]] == 0) -1 else 0
				ic += o
				tc += if (ic == k) 1 else 0
				//println(" ${nums.slice(i..j).toList()} count = $ic ")
			}
			//println("total count $tc")
			for(j in (nums.lastIndex - 1) downTo l) {
				m[nums[j+1]] = m.getOrDefault(nums[j+1], 0) + 1
			}
			p =  nc
		}
		return tc
	}
}

fun main(args: Array<String>) {
	println("Hello World!")
}
