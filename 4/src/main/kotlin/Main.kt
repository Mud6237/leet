// https://leetcode.com/problemset/all?search=4
// https://leetcode.com/problems/median-of-two-sorted-arrays/
// https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation
class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
			if (nums1.size < nums2.size) {
				// first array is larger
				return findMedianSortedArrays(nums2, nums1)
			}
			val n1 = nums1.size // larger array
			val n2 = nums2.size // smaller array
			var lo = 0 
			var hi = nums2.size * 2
			while( lo <= hi ) {
				val mid2 = (lo + hi) / 2
				val mid1 = n1 + n2 - mid2
				val l1 = if(mid1 == 0) Int.MIN_VALUE else nums1[(mid1 - 1) / 2]
				val l2 = if(mid2 == 0) Int.MIN_VALUE else nums2[(mid2 - 1) / 2]
				val r1 = if(mid1 == n1 * 2) Int.MAX_VALUE else nums1[mid1 / 2]
				val r2 = if(mid2 == n2 * 2) Int.MAX_VALUE else nums2[mid2 / 2]
				if (l2 > r1) {
					hi = mid2 - 1
				} else if (l1 > r2) {
					lo = mid2 + 1
				} else {
					return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0
				}

			} 
			return 0.0
    }
}

fun main(args: Array<String>) {
	val nums1 = intArrayOf(1,3)
	val nums2 = intArrayOf(2)
	val expected = 2.00000
	println(Solution().findMedianSortedArrays(nums1, nums2))
}
