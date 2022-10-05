// https://leetcode.com/problemset/all?search=76
// https://leetcode.com/problems/minimum-window-substring/discuss/26840/Sharing-my-straightforward-O(n)-solution-with-explanation
class Solution {
	fun minWindow(s: String, t: String): String {
		if (s.isEmpty() || t.isEmpty()) {
			return ""
		}
		val countMap = hashMapOf<Char, Int>()
		for(c in t) {
			countMap[c] = countMap.getOrDefault(c, 0) + 1
		}
		val windowMap = hashMapOf<Char, Int>()
		var minWindowLength = Int.MAX_VALUE
		var i = 0
		var j = 0
		var letterCount = 0
		var result:String = ""
		while(j < s.length) {
			var c = s[j]
			countMap[c]?.let { count ->
				val wc = windowMap.getOrDefault(c, 0)
				windowMap[c] = wc + 1 
				if (wc <= count) {
					letterCount += 1
				}
			}
			if (letterCount >= t.length) {
				//println("found ${s.substring(0, j+1)} $i, $j")
				var wc = windowMap[s[i]] ?: 0
				val cc = countMap[s[i]]
				//println("wc $wc, cc $cc")
				while(countMap[s[i]] == null || wc > countMap.getOrDefault(s[i] , 0)) {
					wc -= 1
					windowMap[s[i]] = wc
					i += 1
				}
				if (j - i + 1 < minWindowLength) {
					minWindowLength = j - i + 1
					result = s.substring(i, j+1)
				}
			}
			j += 1
		}
		return result		
	}
}

fun main(args: Array<String>) {
	val s = "ADOBECODEBANC"
	val t = "ABC"
	val expected = "BANC"
	println(Solution().minWindow(s, t))

}
