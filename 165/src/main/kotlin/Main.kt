//https://leetcode.com/problemset/all?search=165
// https://leetcode.com/problems/compare-version-numbers/
class Solution {
    fun compareVersion(version1: String, version2: String): Int {
			var r1 = Pair(version1, mutableListOf<Int>())
			var r2 = Pair(version2, mutableListOf<Int>())
			for ((str, r) in arrayOf(r1, r2)) {
				var i = 0
				while(i < str.length) {
					var j = i
					while(j < str.length && str[j] == '0') {
						j += 1
					}
					var k = j
					while(k < str.length && str[k] != '.') {
						k += 1
					}
					if (k > j) {
						r.add(str.substring(j, k).toInt())
					} else {
						r.add(0)
					}
					i = k + 1
				}
			}
			var i = 0 
			var j = 0
			while(i < r1.second.size && j < r2.second.size) {
				if (r1.second[i] != r2.second[j]) {
					return if (r1.second[i] < r2.second[j]) -1 else 1
				}
				i += 1
				j += 1
			}
			
			for(k in i until r1.second.size) {
				if (r1.second[k] != 0) {
					return 1
				}
			}
			for(k in j until r2.second.size) {
				if (r2.second[k] != 0) {
					return -1
				}
			}
			//println("r1 = ${r1.second}")
			//println("r2 = ${r2.second}")
			return 0
    }
}
fun main() {
	println(Solution().compareVersion("1.0.0", "1.00000000000000000000000000000000000011"))
	println(Solution().compareVersion("0.1.0", "1.0"))
	println(Solution().compareVersion("1.01", "1.001"))
	println(Solution().compareVersion("1.0", "1.0.0"))
	println(Solution().compareVersion("9.101", "9.1001"))
	println(Solution().compareVersion("0.1", "1.1"))
	println(Solution().compareVersion("20", "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"))
}
