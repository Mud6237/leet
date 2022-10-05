//https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
class Solution {
    fun minSwaps(data: IntArray): Int {
        val c = data.sum()
        if (c <= 1) {
            return 0
        }
        var k = 0
        for(i in 0 until c) {
            k += data[i]
        }
        var s = c - k
        for(i in 1..data.size - c) {
            k -= data[i-1]
            k += data[i+(c-1)]
            s = Math.min(s, c-k)
        }
        return s
    }
}