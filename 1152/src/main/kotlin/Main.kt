//https://leetcode.com/problemset/all?search=1152
//https://leetcode.com/problems/analyze-user-website-visit-pattern/
class Solution {

	fun mostVisitedPattern(username: Array<String>, timestamp: IntArray, website: Array<String>): List<String> {
		val tuples = Array<Triple<String, Int, String>>(username.size, {
			Triple(username[it], timestamp[it], website[it])
		})
		tuples.sortWith(
			compareBy<Triple<String, Int, String>>({ it.first })
			.thenBy({ it.second })
		)
		//println(tuples.toList())
		var previous = tuples.first()
		var lastIndex = 0
		val h = hashMapOf<Triple<String, String, String>, Int>()
		var maxScore = Int.MIN_VALUE
		var maxScorePattern = Triple("~", "", "")
		val tc = compareBy<Triple<String, String, String>>({ it.first })
						.thenBy({ it.second })
						.thenBy({ it.third })
		fun findPatterns(startIndex: Int, endIndex: Int) {
			val userVisitMap = hashSetOf<Triple<String, String, String>>()
			for(p in startIndex..endIndex - 2) {
				for(q in p+1..endIndex-1) {
					for(r in q+1..endIndex) {
						val pattern = Triple(tuples[p].third,tuples[q].third,tuples[r].third)
						if (!userVisitMap.contains(pattern)) {
							userVisitMap.add(pattern)
							//println(" ${pattern}")
							val score  = h.getOrDefault(pattern, 0) + 1
							h[pattern] = score
							if (score >= maxScore) {
								if (score == maxScore) {
									if(tc.compare(pattern, maxScorePattern) <= 0) {
										maxScorePattern = pattern
									}
								} else {
									maxScorePattern = pattern
								}
								maxScore = score
							}
						}
					}
				}
			}
		}
		for((index, tuple) in tuples.withIndex()) {
			if (tuple.first != previous.first) {
				//val fromIndex = lastIndex
				//println("Patterns for ${tuples[fromIndex].first} fromIndex = $fromIndex, toIndex = ${index-1}")
				findPatterns(lastIndex, index - 1)
				lastIndex = index
			}
			previous = tuple
		}
		findPatterns(lastIndex, tuples.lastIndex)
		return listOf(maxScorePattern.first, maxScorePattern.second, maxScorePattern.third)
	}
}
