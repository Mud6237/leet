// https://leetcode.com/problems/restore-ip-addresses/
class Solution {

	fun isValid(i: Int, j: Int, s: String): Int {
		if (j - i < 1) {
			return 0
		}
		var x = i
		while(x < j) {
			if (s[x] < '0' || s[x] > '9') {
				return -1
			}
			x += 1
		}
		if(s[i] != '0') {
			val v = s.slice(i until j).toInt()
			if (v > 255) {
				return 0 
			} else {
				return 1
			}
		} else {
			if (j - i == 1) {
				return 1
			} else {
				return 0
			}
		}
	}

	fun getIP(s: String, r: IntArray): String {
		return "${s.substring(0, r[1])}.${s.substring(r[1], r[2])}.${s.substring(r[2], r[3])}.${s.substring(r[3], s.length)}"
	}

	fun restoreIpAddresses(s: String): List<String> {
		if (s.length > 12) {
			return emptyList<String>()
		}
		val queue = ArrayDeque<Pair<Int, String>>()
		queue.addFirst(Pair(0, ""))
		val validRanges = mutableListOf<String>()
		while(queue.isNotEmpty()) {
			val levelSize = queue.size
			for(i in 0 until levelSize) {
				val front = queue.removeFirst()
				val startIndex = front.first
				var sz = 1
				while(sz <= 3 && startIndex + sz <= s.length) {
					val endIndex = startIndex + sz
					sz += 1
					val valid = isValid(startIndex, endIndex, s)
					if (valid <= 0) {
						if (valid < 0) {
							return emptyList<String>()
						}
						continue
					}
					val prefix = if (front.second.length > 0) "${front.second}." else ""
					val nextString = "${prefix}${s.substring(startIndex, endIndex)}"
					if (endIndex == s.length && nextString.length == s.length + 3) {
						validRanges.add(nextString)
					} else {
						queue.add(Pair(endIndex, nextString))
					}
				}
			}
		}
		return validRanges
	}
}
