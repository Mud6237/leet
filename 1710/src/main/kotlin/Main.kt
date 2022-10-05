//https://leetcode.com/problemset/all?search=1710
import java.util.PriorityQueue
class Solution {
	fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
		val comparator = compareBy<IntArray>({ it.last() }).reversed()
		boxTypes.sortWith(comparator)
		var u = 0
		var s = truckSize
		for(i in 0 until boxTypes.size) {
			val (a, b) = boxTypes[i]
			val d = Math.min(a, s)
			u += d * b
			s = s - a
			if (s <= 0) {
				break
			}
		}
		return u
	}
}