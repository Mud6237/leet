//https://leetcode.com/problems/group-anagrams/
class Solution {
	
	fun groupAnagrams(strs: Array<String>): List<List<String>> {
		var h = hashMapOf<String, MutableList<String>>()
		for(str in strs) {
			val ca = str.toCharArray()
			ca.sort()
			val s = ca.joinToString("")
			val l = h.getOrPut(s, { mutableListOf<String>() })
			l.add(str)
		}
		return h.values.toList()
	}
}