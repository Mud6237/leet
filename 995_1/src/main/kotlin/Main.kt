//https://leetcode.com/problemset/all?search=995
//https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
class Solution {
    fun minKBitFlips(nums: IntArray, k: Int): Int {
        var count = 0
        val flipped = IntArray(nums.size)
        for(i in 0 until nums.size) {
            val f = flipped[i] % 2
            if(
                (nums[i] == 0 && f == 0) ||
                (nums[i] == 1 && f == 1)
            ) {
                if(i + k > nums.size) {
                    return -1
                }
                count += 1
                for(j in i until Math.min(flipped.size, i + k)) {
                    flipped[j] += 1
                }
            }
        }
        return count
    }
}