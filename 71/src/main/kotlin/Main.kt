//https://leetcode.com/problemset/all?search=71
//https://leetcode.com/problems/simplify-path/
class Solution {
	fun simplifyPath(path: String): String {
		val stack = mutableListOf<String>("")
		var i = 0
		while(i < path.length) {
			var s = i
			var c = path[s]
			var j = s+1
			while(j < path.length && path[j] == c) {
				s += 1
				j += 1
			}
			var ss: String
			var e = s+1
			while(e < path.length && path[e] != '/') {
				e += 1	
			}
			ss = path.slice(s+1 until e)
			var isParent = ss == ".."
			var isCurrent = ss == "."
			if (isParent || isCurrent) {
				if(isParent && stack.size > 1) {
					stack.removeAt(stack.lastIndex)
				}
			} else {
				if (ss.length > 0) {
					stack.add(ss)
				}
			}
			i = e
		}
		if (stack.size == 1) {
			stack.add("")
		}
		return stack.joinToString("/")
	}
}