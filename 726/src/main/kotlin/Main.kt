//https://leetcode.com/problemset/all?search=726
// https://leetcode.com/problems/number-of-atoms/

class Solution {
	companion object {

		fun isLowerCase(c: Char): Boolean {
			return c >= 'a' && c <= 'z'
		}
		
		fun isUpperCase(c: Char): Boolean {
			return c >= 'A' && c <= 'Z'
		}

		fun isDigit(c: Char): Boolean {
			return c >= '0' && c <= '9'
		}
	}
	data class Atom(
		val name: String,
		var count: Int
	)

	fun countOfAtoms(formula: String): String {
		var i = 0
		var n = formula.length
		var stack = mutableListOf<Atom>()
		while(i < n) {
			if(formula[i] == '(' ) {
				stack.add(Atom("(", 0))
				i += 1
			} else if (formula[i] == ')' )  {
				var k = i + 1
				while(k < n && isDigit(formula[k])) {
					k += 1
				}
				var count = formula.substring(i+1, k).toInt()
				var prev = stack.removeLast()
				var sIndex = stack.lastIndex
				while(sIndex >= 0 && prev.name != "(" ) {
					val t = stack[sIndex]
					stack[sIndex] = prev
					stack[sIndex].count *= count
					sIndex -= 1
					prev = t
				}
				i = k
			} else {
				var j = i+1
				while(j < n && isLowerCase(formula[j])) {
					j += 1
				}
				var atomName = formula.substring(i, j)
				var k = j
				while(k < n && isDigit(formula[k])) {
					k += 1
				}
				var atomCount = if (k == j) 1 else formula.substring(j, k).toInt()
				stack.add(Atom(atomName, atomCount))
				i = k
			}
		}
		val h = HashMap<String, Int>()
		for(atom in stack) {
			val c = h.getOrDefault(atom.name, 0)
			h[atom.name] = c + atom.count
		}
		val resList  = h.entries.map { Pair(it.key, it.value )}.toMutableList()
		resList.sortWith {p1, p2 -> p1.first.compareTo(p2.first) }
		var sb = StringBuilder()
		for(atom in resList) {
			sb.append(atom.first)
			if (atom.second > 1) {
				sb.append(atom.second)
			}
		}
		return sb.toString()
	}

}

fun main() {
	println(Solution().countOfAtoms("K4(ON(SO3)2)2"))
}
