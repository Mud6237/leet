// https://leetcode.com/problemset/all?search=466
// https://leetcode.com/problems/count-the-repetitions/

class Solution {
	fun getMaxRepetitions(s1: String, n1: Int, s2: String, n2: Int): Int {
		if (s1.isEmpty() || s2.isEmpty()) { return 0 }
		val r1 = Math.max((s2.length / s1.length), 2)
		var c1 = s1.length * r1
		var j = 0
		var count = 0
		for(i in 0 until c1) {
			val i1 = i % s1.length
			var i2 = j % s2.length
			if (s1[i1] == s2[i2]) {
				j += 1
				if (j % s2.length == 0) {
					count += 1
				}
			}
		}
		val repPerCount = r1.toDouble() / count.toDouble()
		//println("r1 = $r1, count = $count repPerCount = $repPerCount ")
		if (n1 < repPerCount * n2) {
			//println("not possible because s1 doesn't repeat enough times")
			return 0
		}
		return (n1 / (repPerCount * n2)).toInt()
		//println("repetitions = $r1 count = $count $repPerCount repPerCount * n2 = ${repPerCount * n2} n1 = $n1")
		//return n1 + n2
	}
}

fun main() {
	val s1 = ""
	val n1 = 2
	val s2 = ""
	val n2 = 1
	println(Solution().getMaxRepetitions(s1, n1, s2, n2))
	
}
