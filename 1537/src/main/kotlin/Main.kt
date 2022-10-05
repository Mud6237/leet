//https://leetcode.com/problemset/all?search=1537
//https://leetcode.com/problems/get-the-maximum-score/
//https://leetcode.com/problems/get-the-maximum-score/discuss/767987/JavaC++Python-Two-Pointers-O(1)-Space/640646
class Solution {
	fun maxSum_slow(nums1: IntArray, nums2: IntArray): Int {
		var set1 = hashMapOf<Int, Pair<Int, Int>>()
		val set2 = hashMapOf<Int, Pair<Int, Int>>()
		var prev = 0
		var mod = 1_000_000_007
		for(i in nums1.lastIndex downTo 0) {
			val s = ((nums1[i] % mod) + prev) % mod
			set1[nums1[i]] = Pair(s, i)
			prev = s
		}
		val sum1 = prev
		prev = 0
		for(i in nums2.lastIndex downTo 0) {
			val s = ((nums2[i] % mod) + prev) % mod
			set2[nums2[i]] = Pair(s, i)
			prev = s
		}
		val sum2 = prev
		var (a1, a2) = if (sum1 >= sum2) Pair(nums1, nums2) else Pair(nums2, nums1)
		var (s1, s2) = if (sum1 >= sum2) Pair(set1, set2) else Pair(set1, set2)
		var i = 0
		var t = 0
		while(i < a1.size) {
			val k = a1[i] % mod
			t = (t + k) % mod
			var swap = true
			val sk2 = s2[k]
			val sk1 = s1.remove(k)
			if (sk2 != null) {
				if (sk1 != null && sk1.first > sk2.first) {
					swap = false
				}
				if (swap) {
					var ta = a1
					a1 = a2
					a2 = ta
					var ts = s1
					s1 = s2
					s2 = ts
					i = sk2.second
					t -= k
				} else {
					i += 1	
				}
			} else {
				i += 1
			}
		}
		return t
	}

	fun maxSum(nums1: IntArray, nums2: IntArray): Int {
		var i = 0
		var j = 0
		var a = 0
		var b = 0
		var t = 0
		while(i < nums1.size && j < nums2.size) {
			if (nums1[i] == nums2[j]) {
				t += Math.max(a, b)
				a = nums1[i]
				b = a
				i += 1
				j += 1
			} else {
				if (nums2[j] < nums1[i]) {
					b += nums2[j]
					j += 1
				} else {
					a += nums1[i]
					i += 1
				}
			}	
		}
		while(i < nums1.size) {
			a += nums1[i]
			i += 1
		}
		while(j < nums2.size) {
			b += nums2[j]
			j += 1
		}
		t += Math.max(a, b)
		return t
	}
}
fun main() {
	println(Solution().maxSum(intArrayOf(2, 4, 5, 8, 10), intArrayOf(4, 6, 8, 9)))
	println(Solution().maxSum(intArrayOf(2, 4, 8, 10), intArrayOf(4, 8, 11)))
	println(Solution().maxSum_slow(intArrayOf(2, 4, 8, 10), intArrayOf(4, 8, 11)))
}
