//https://leetcode.com/problems/minimum-window-subsequence/
//https://leetcode.com/problems/minimum-window-subsequence/discuss/?currentPage=1&orderBy=hot&query=
class Solution {
    fun lcs(s1: String, s2: String): String {
        val a = Array(s1.length + 1,  { IntArray(s2.length + 1) })
        var x = 0
        var y = 0
        var l = Int.MAX_VALUE
        var p = -1
        for(i in 1..s1.length) {
            for(j in 1..s2.length) {
                if (s1[i-1] == s2[j-1]) {
                    if (a[i-1][j-1] == 0) {
                        p = i-1
                        //println("-->${s1.substring(i-1, s1.length)}")
                    }
                    a[i][j] = a[i-1][j-1] + 1
                    if (a[i][j] == s2.length) {
                        if (i - p < l) {
                            l = i - p
                            y = i
                            x = p
                        }
                        //println("-->${s1.substring(p, i)}")
                    }
                } else {
                    a[i][j] = Math.max(a[i-1][j], a[i][j-1])
                }
            }
        }
        //println("p = $p, x = $x")
        //println(("_" + s2).toCharArray().toList())
        //var s2b = ("_" + s1).toCharArray().toList()
        //a.forEachIndexed{ index, it -> print(s2b[index]); println(it.toList()) }
        if (a[s1.length][s2.length] != s2.length) {
            return ""
        }
        return s1.substring(x, y)
    }
    fun minWindow(s1: String, s2: String): String {
        return lcs(s1, s2)
    }
}
fun main() {
    val s1 = "abc"
    val s2 = "bcd"
	println(Solution().minWindow(s1, s2))
}
