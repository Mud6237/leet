//https://leetcode.com/problems/encode-string-with-shortest-length/
//https://leetcode.com/problems/encode-string-with-shortest-length/discuss/95599/Accepted-Solution-in-Java
class Solution {
    fun encode_wrong(s: String): String {
        var sb = StringBuilder()
        var i = 0
        while(i < s.length) {
            val c = s[i]
            var j = i + 1
            while(j < s.length && s[j] == c ) {
                j += 1
            }
            val count = (Math.min(s.lastIndex, j) - i) + 1
            if (count > 4) {
                sb.append("$count[$c]")
            } else {
                sb.append(s.substring(i, j))
            }
            i = j
        }
        return sb.toString()
    }

    fun match(s: String, i: Int, j: Int) : Int {
        var x = i
        var y = j
        while(y > x) {
            var q = y
            while(y > x && s[x] == s[q]) {
                x += 1
                q += 1
            }
            if (x == y) {
                return (x - i)
            }
            y = y-1
            x = i
        }
        return 0
    }

    fun digitsCount(n: Int): Int {
        var c = 0
        var j = n
        while(j > 0) {
            c += 1
            j = j / 10
        }
        return c
    }

    fun encode_wrong_also(s: String): String {
        var encodedList = MutableList(s.length, {""})
        encodedList[0] = s.first().toString()
        val subStringMap = hashMapOf<String, Pair<Int, Int>>()
        var cnt = 1
        for(i in 1 until s.length) {
            encodedList[i] = encodedList[i-1] + s[i]
            var j = i - 1
            //println("For ${s[i]}: Comparing")
            val newCount = if (s[i] == s[i-1]) cnt + 1 else 1
            cnt = newCount
            if (newCount >= 5) {
                val lastIndex = (i - newCount) + 1
                val last = encodedList[lastIndex]
                if (last.length - 1 + 3 + digitsCount(newCount) <= encodedList[i].length) {
                    encodedList[i] = last.substring(0, last.length - 1) + "$newCount[${s[i]}]"
                }
            }
            while(j >= (i - j) + 1) {
                val left = s.substring(0, j)
                val right = s.substring(j, i+1)
                if (left.endsWith(right)) {
                    var c = 2
                    val (lastCount, lastMatchingIndex) = subStringMap[right] ?: Pair(0, -1)
                    if (lastMatchingIndex == j - right.length) {
                        c = lastCount + 1
                    }
                    subStringMap[right] = Pair(c, j)
                    var leftIndex = i - right.length * c
                    var leftStr = if (leftIndex < 0) "" else encodedList[leftIndex]
                    var rightStr = if (leftIndex < 0) encodedList[j-1] else right
                    if (leftStr.length + rightStr.length + 2 + digitsCount(c) < encodedList[i].length) {
                        encodedList[i] = leftStr + "$c[$rightStr]"
                    }
                }
                j -= 1
            }
        }
        return encodedList.last()
    }

    fun encode(s: String): String {
        val dp = Array(s.length, { Array(s.length, { "" })})
        for(l in 0 until s.length) {
            for( i in 0 until s.length - l) {
                val j = i + l
                val substr = s.substring(i, j+1)
                dp[i][j] = substr
                if (j - i < 4) {
                    continue
                }
                for(k in i until j) {
                    if (dp[i][k].length + dp[k+1][j].length < dp[i][j].length) {
                        dp[i][j] = dp[i][k] + dp[k+1][j]
                    }
                }
                for(k in 0 until substr.length) {
                    val r = substr.substring(0, k+1)
                    if ((substr.length % r.length) == 0 && substr.replace(r, "").length == 0) {
                        val rc = substr.length / r.length
                        val rStr = "$rc[${dp[i][i+k]}]"
                        if (rStr.length < dp[i][j].length) {
                            dp[i][j] = rStr
                        }
                    }
                }
            }
        }
        return dp[0][s.length - 1]
    }
}

fun main() {
	println(Solution().encode("aabcaabcd"))
	println(Solution().encode("pbcabcabcabcdq"))
	println(Solution().encode("aaaaaaaaaabaaaaaaaaaab"))
	println(Solution().encode("aaaaaaaaaa"))
	println(Solution().encode_wrong_also("ababababababababab"))
}
