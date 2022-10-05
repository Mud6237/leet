//https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
//https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/discuss/129021/O(N)-Java-Solution-DP-Clear-and-easy-to-Understand
class Solution {

	fun sumFrom(n: Int): Int {
		return (n * (n + 1)) / 2
	}

	fun uniqueLetterString_BruteForce(s: String): Int {
		var totalCount = 0
		var countArray = IntArray(26)
		var totalUniqueCount = 0
		for(c in s) {
			val i = c - 'A'
			countArray[i] += 1
		}
		for(e in countArray) {
			if (e == 1) {
				totalUniqueCount += 1
			}
		}
		var uniqueCount = totalUniqueCount
		//println("totalUniqueCount = $totalUniqueCount")
		for(i in 0 until s.length) {
			var uc = uniqueCount
			if (uc == s.length - i) {
				for(k in 1..uc) {
					totalCount += sumFrom(k)
				}
				break
			}
			val ucArray = countArray.copyOf()
			//println("For Char ${s[i]}")
			for(j in s.length downTo i+1) {
				//println(s.substring(i, j))
				totalCount += uc
				val k = s[j-1] - 'A'
				ucArray[k] -= 1
				if (ucArray[k] == 0) {
					uc -= 1
				} else if (ucArray[k] == 1) {
					uc += 1
				}
				//println("substring = ${s.substring(i, j)} discarding ${s[j-1]} remaining unique count = $uc")
			}
			var k = s[i] - 'A'
			countArray[k] -= 1
			if (countArray[k] == 0) {
				uniqueCount -= 1
			} else if(countArray[k] == 1) {
				uniqueCount += 1
			}
		}
		return totalCount
	}

	fun uniqueLetterString(s: String): Int {
		val countArr = IntArray(26, { 0 })
		val lastOccurence = IntArray(26, { -1 })
		var c = 0
		var totalCount = 0
		for(i in 0 until s.length) {
			val x = s[i]
			val xi = x - 'A'
			val k = (i - lastOccurence[xi])
			c = c - countArr[xi] + k
			totalCount += c
			countArr[xi] = k
			lastOccurence[xi] = i
		}
		return totalCount
	}
}