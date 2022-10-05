// https://leetcode.com/problemset/all?search=943
// https://leetcode.com/problems/find-the-shortest-superstring/
// https://leetcode.com/problems/find-the-shortest-superstring/discuss/194932/Travelling-Salesman-Problem
class Solution {
    companion object {
        fun distance(s1: String, s2: String): Int {
            for(i in 1 until s1.length) {
                if(s2.startsWith(s1.substring(i))) {
                    return s2.length - (s1.length - i)
                }
            }
            return s2.length
        }
    }
    
    fun shortestSuperstring(words: Array<String>): String {
        var graph = Array<IntArray>(words.size, { IntArray(words.size) })
        for(i in 0..words.lastIndex) {
            for(j in 0..words.lastIndex) {
                graph[i][j] = distance(words[i], words[j])
            }
        }
        val n = words.size
        val N = 1 shl words.size
        val A = Array(N, { IntArray(n) })
        for (k in 1 until N) {
            for( i in 0 until n ) {
                val mask1 = 1 shl (n - 1 - i)
                if ((k and mask1) == mask1) {
                    val l = k xor mask1
                    if (l == 0) {
                        A[k][i] = words[i].length
                        continue
                    }
                    var m = Int.MAX_VALUE
                    for(j in 0 until n) {
                        val mask2 = 1 shl (n - 1 - j)
                        if ((l and mask2) == mask2) {
                            m = Math.min(m, A[l][j] + graph[j][i])
                        }
                    }
                    A[k][i] = m
                } else {
                    A[k][i] = Int.MAX_VALUE
                }
            }
        }
        var k = N-1
        var c = n - 1
        var resOrder = IntArray(words.size)
        while(c >= 0) {
            var minDist = Int.MAX_VALUE
            var minDistIndex = Int.MAX_VALUE
            for(i in 0 until n) {
                if (A[k][i] < minDist) {
                    minDist = A[k][i]
                    minDistIndex = i
                }
            }
            if (minDist >= Int.MAX_VALUE) {
                break
            }
            resOrder[c] = minDistIndex
            c -= 1
            k = k xor (1 shl (n-1-minDistIndex))
        }
        var resStringBuilder = StringBuilder()
        resStringBuilder.append(words[resOrder.first()])
        for(i in 1..resOrder.lastIndex) {
            val u = resOrder[i-1]
            val v = resOrder[i]
            resStringBuilder.append(words[v].substring(words[v].length - graph[u][v]))
        }
        return resStringBuilder.toString()
    }
}

fun main() {
	println("Hello World!")
}
