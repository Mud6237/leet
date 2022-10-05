//https://leetcode.com/problemset/all?search=480
//https://leetcode.com/problems/sliding-window-median/
//https://leetcode.com/problems/sliding-window-median/discuss/96346/Java-using-two-Tree-Sets-O(n-logk)
//When it comes to duplicate values so to get around this we store the index into nums in our Tree Set. To break ties in our Tree Set comparator we compare the index.
import java.util.TreeSet
import java.util.Comparator

class Solution {

	fun<T> rebalanceTrees(left: TreeSet<T>, right: TreeSet<T>) {
		while(left.size - right.size > 1) {
			right.add(left.pollFirst())
		}
		while(right.size - left.size > 1) {
			left.add(right.pollFirst())
		}
	}

	fun addToHeap(a: Int, left: TreeSet<Int>, right: TreeSet<Int>) {
		if (left.isNotEmpty() && left.comparator().compare(left.first(), a) < 0 ) {
			left.add(a)
		} else if (right.isNotEmpty() && right.comparator().compare(a, right.first()) > 0 ) {
			right.add(a)
		} else {
			left.add(a)
		}
		if (left.size - right.size > 1) {
			right.add(left.pollFirst())
		}
	}
	
	fun removeFromHeap(a: Int, left: TreeSet<Int>, right: TreeSet<Int>) {
		if (!left.remove(a)) {
			right.remove(a)
		}
	}

	fun getMedia(nums: IntArray, left: TreeSet<Int>, right: TreeSet<Int>): Double {
		if (left.size == right.size) {
			return (nums[left.first()] + nums[right.first()]) / 2.0
		} else if (left.size > right.size) {
			return (nums[left.first()]).toDouble()
		} else {
			return (nums[right.first()]).toDouble()
		}
	}

	fun printHeap(h: TreeSet<Int>, nums: IntArray): String {
		val sb = StringBuilder()
		h.forEach{ sb.append(nums[it], ",") }
		return sb.toString()
	}

	fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
		val result = DoubleArray(nums.size - k + 1)
		val comparator = Comparator<Int>({ i, j ->
			val e = Integer.compare(nums[i], nums[j])
			if (e == 0) {
				i - j
			} else {
				e
			}
		})
		val right = TreeSet<Int>(comparator)
		val left = TreeSet<Int>(comparator.reversed())
		for(i in 0 until k) {
			addToHeap(i, left, right)
		}
		result[0] = getMedia(nums, left, right)
		//println("Left Heap = ${printHeap(left, nums)} right Heap = ${printHeap(right, nums)} ")
		var j = 1
		for(i in k until nums.size) {
			//println("Removing ${nums[i-k]}")
			removeFromHeap(i - k, left, right)
			rebalanceTrees(left, right)
			//println("After removal: Left Heap = ${printHeap(left, nums)} right Heap = ${printHeap(right, nums)} ")
			addToHeap(i, left, right)
			//println("After Adding ${nums[i]}: Left Heap = ${printHeap(left, nums)} right Heap = ${printHeap(right, nums)} ")
			result[j] = getMedia(nums, left, right)
			//println("New median ${result[j]} ")
			j += 1
		}
		return result
	}
}
fun main() {
	println("Hello World!")
}
