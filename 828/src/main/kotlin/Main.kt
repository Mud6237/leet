// https://leetcode.com/problemset/all?search=828

class Solution {
	companion object {
		fun toIndex(c: Char): Int {
			return (c - 'A').toInt() 
		}
	}
	fun uniqueLetterString(s: String): Int {
		var countMap = IntArray(26)
		var uniqueCount = s.length
		for(c in s) {
			val i = toIndex(c)
			countMap[i] += 1
		}
		for(v in countMap) {
			if (v > 1) {
				uniqueCount -= v
			}
		}
		var totalCount = 0
		var prev = uniqueCount
		println("total count $totalCount")
		for(i in 0..s.lastIndex) {
			var u = if (i > 0) {
				val idx = toIndex(s[i-1])
				countMap[idx] -= 1
				var k = prev
				if (countMap[idx] == 0) {
					k -= 1
				} else if (countMap[idx] == 1) {
					k += 1
				}
				k
			} else {
				prev
			}
			var p = u
			totalCount += p
			println("Remaining string ${s.substring(i, s.length)} unique count $u starting at $p")
			val bc = countMap.copyOf()
			for(j in (s.lastIndex - 1) downTo i) {
				val idx = toIndex(s[j+1])
				countMap[idx] -= 1
				if (countMap[idx] == 0) {
					p = p - 1
				} else if (countMap[idx] == 1) {
					p += 1
				}
				println("${s.substring(i, j+1)} Unique count = $p ")
				totalCount += p
			}
			println("")
			prev = u
			countMap = bc
		}
		return totalCount
	}
}

fun main(args: Array<String>) {
	println(Solution().uniqueLetterString("LEETCODE"))
	println(Solution().uniqueLetterString("ABC"))
	println(Solution().uniqueLetterString("ABA"))
}
