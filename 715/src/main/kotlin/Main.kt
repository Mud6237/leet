//https://leetcode.com/problemset/all?search=715
//https://leetcode.com/problems/range-module/
import java.util.TreeSet

class RangeModule() {
	private val intervalSet = TreeSet<Interval>() { interval1, interval2 -> 
		if (interval1.left == interval2.left) interval1.right - interval2.right else interval1.left - interval2.left
	}

	private data class Interval(val left: Int, val right: Int) {
		fun overlap(other: Interval): Boolean {
			if (other.right < left || right < other.left) {
				return false
			}
			return true
		}

		fun contains(other: Interval): Boolean {
			if (other.left >= left && other.right <= right) {
				return true
			}
			return false
		}
	}

	private fun merge(interval1: Interval, interval2: Interval): Interval {
		return Interval(left = Math.min(interval1.left, interval2.left), right = Math.max(interval1.right, interval2.right))
	}

	fun addRange(left: Int, right: Int) {
		val inputInterval = Interval(left, right)
		val leftFloor = intervalSet.floor(inputInterval)
		var targetInterval = inputInterval
		if (leftFloor != null && leftFloor.overlap(targetInterval)) {
			intervalSet.remove(leftFloor)
			targetInterval = merge(leftFloor, targetInterval)
		}
		val leftCeil = intervalSet.ceiling(inputInterval)
		if (leftCeil != null && leftCeil.overlap(targetInterval)) {
			intervalSet.remove(leftCeil)
			targetInterval = merge(leftCeil, targetInterval)
		}
		val rightFloor = intervalSet.floor(Interval(right, Int.MAX_VALUE))
		//println("inputInterval $inputInterval, rightFloor = $rightFloor ")
		if (rightFloor != null && rightFloor.overlap(targetInterval)) {
			intervalSet.remove(rightFloor)
			targetInterval = merge(rightFloor, targetInterval)
		}
		intervalSet.add(targetInterval)
	}

	fun queryRange(left: Int, right: Int): Boolean {
		val inputInterval = Interval(left, right)
		val leftFloor = intervalSet.floor(inputInterval)
		if (leftFloor != null && leftFloor.contains(inputInterval)) {
			return true
		}
		val leftCeil = intervalSet.ceiling(inputInterval)
		if (leftCeil != null && leftCeil.contains(inputInterval)) {
			return true
		}
		return false
	}

	private fun split(interval1: Interval, interval2: Interval): List<Interval> {
		var result = mutableListOf<Interval>()
		if (interval1.left < interval2.left) {
			result.add(Interval(interval1.left, interval2.left))
		}
		if (interval1.right > interval1.left) {
			result.add(Interval(interval2.right, interval1.right))
		}
		return result
	}

	fun removeRange(left: Int, right: Int) {
		val inputInterval = Interval(left, right)
		val leftFloor = intervalSet.floor(inputInterval)
		if (leftFloor != null && leftFloor.overlap(inputInterval)) {
			intervalSet.remove(leftFloor)
			for(interval in split(leftFloor, inputInterval)) {
				intervalSet.add(interval)
			}
		}
		var leftCeil = intervalSet.ceiling(inputInterval)
		if (leftCeil != null && leftCeil.overlap(inputInterval)) {
			intervalSet.remove(leftCeil)
			for(interval in split(leftCeil, inputInterval)) {
				intervalSet.add(interval)
			}
		}
	}

	override fun toString(): String {
		return intervalSet.toString()
	}

}

fun main() {
	var rm = RangeModule()
	rm.addRange(10, 20)
	rm.removeRange(14, 16)
	println(rm.queryRange(10, 14))
	println(rm.queryRange(13, 15))
	println(rm.queryRange(16, 17))
	println(rm)
}
