// https://leetcode.com/problemset/all?search=493
// https://leetcode.com/problems/reverse-pairs/
import java.util.TreeSet
class Solution {
	fun reversePairs(nums: IntArray): Int {
		var t = TreeSet<Pair<Int, Int>>{p1, p2 -> p2.first - p1.first}
		val h = 1073741823
		val r = IntArray(nums.size)
		var j = 0
		var count  = 0
		for((_, n) in nums.withIndex()) {
			if (n >= 0 && n <= h) {
				val q = (n * 2) + 1
				//println("For n = $n, looking for q = $q floor = ${t.floor(Pair(q, 0))} ")
				count += t.floor(Pair(q, 0))?.second ?: 0
			} else if (n < 0 ) {
				val q = (n + 1) / 2
				//println("For n = $n, looking for q = $q floor = ${t.floor(Pair(q, 0))} ")
				count += t.floor(Pair(q, 0))?.second ?: 0
			}
			var index = r.binarySearch(-n, 0, j)
			if (index < 0) {
				index = - (index + 1)
			}
			r[index] = -n
			if (index == j) {
				j += 1
			}
			val p = Pair(n, 0)
			val c = t.floor(p)
			//println("Ceiling for ${p} =${c} ")
			t.remove(p)
			t.add(Pair(n, index + 1 + (c?.second ?: 0)))
			//println("n = $n, index = ${index}, r =${r.toList()} t = $t")
		}
		//println(t)
		return count 
	}

	fun reversePairsImpl(nums: IntArray , i: Int, j: Int): Int {
		if (i >= j) {
			return 0
		}
		val mid = i + (j - i) / 2
		var count = reversePairsImpl(nums, i, mid) + reversePairsImpl(nums, mid+1, j)
		var p = i
		var q = mid + 1
		while(p <= mid) {
			while(q <= j && nums[p] / 2.0 > nums[q] ) {
				q += 1
			}
			count += q - (mid + 1)
			p += 1
		}
		nums.sort(fromIndex = i, toIndex = j + 1)
		return count
	}

	fun reversePairs_merge(nums: IntArray): Int {
		return reversePairsImpl(nums, 0, nums.lastIndex)
	}


}
fun main() {
	var nums = intArrayOf(1,3,2,3,1)
	println(Solution().reversePairs(nums))
	nums = intArrayOf(2,4,3,5,1)
	println(Solution().reversePairs(nums))
	nums = intArrayOf(4, 0, 0, 0, )
	println(Solution().reversePairs(nums))
	nums = intArrayOf(4, 9, 3)
	println(Solution().reversePairs(nums))
	nums = intArrayOf(2147483647,2147483647,2147483647,2147483647,2147483647,2147483647)
	println(Solution().reversePairs(nums))
}
