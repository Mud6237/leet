//https://leetcode.com/problemset/all?search=139
//https://leetcode.com/problems/word-break/

class Solution {
	
	fun wordBreak(s: String, wordDict: List<String>): Boolean {
		val wordSet = hashSetOf<String>()
		wordSet.addAll(wordDict)
		val dp = BooleanArray(s.length + 1)
		dp[0] = true
		for(j in 1..s.length) {
			//println("For j = $j")
			for(i in j downTo 1) {
				dp[j] = dp[i-1] && wordSet.contains(s.slice(i-1 until j))
				if(dp[j]) {
					break
				}
				//println("lower is ${dp[i-1]} checking ${s.slice(i-1 until j)}")
			}
			//println()
		}
		//println(dp.toList())
		return dp[s.length]
	}
}