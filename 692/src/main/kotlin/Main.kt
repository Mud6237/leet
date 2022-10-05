//https://leetcode.com/problemset/all?search=692
//https://leetcode.com/problems/top-k-frequent-words/
import java.util.PriorityQueue
class Solution {
	fun topKFrequent(words: Array<String>, k: Int): List<String> {
		val comparator = compareBy<Pair<String, Int>>({ it.second })
				.reversed()
				.thenBy({ it.first })
		val pq = PriorityQueue<Pair<String, Int>>(comparator.reversed())
		val h = hashMapOf<String, Int>()
		for(word in words) {
			val count = h.getOrDefault(word, 0) + 1
			h[word] = count
		}
		for(entry in h) {
			pq.add(entry.key to entry.value)
			if (pq.size > k) {
				pq.poll()
			}
		}
		var result = MutableList<String>(k, { "" })
		var j = k - 1
		while(pq.isNotEmpty()) {
			result[j] = pq.poll().first
			j -= 1
		}
		return result
	}
}