class Solution {
	companion object {
		fun isValid(s: CharArray): Boolean {
			var k = 0
			for(c in s) {
				if (c == '(') {
					k += 1
				} else {
					k -= 1
				}
				if( k < 0){
					return false
				}
			}
			return k == 0
		}    
	}

	private fun swap(p: CharArray, i: Int, j: Int) {
		val t = p[i]
		p[i] = p[j]
		p[j] = t
	}
	
	private fun generateParenthesisImpl(p: CharArray, i: Int, n: Int, result: MutableList<String>) {
		if (i == n) {
			if(isValid(p)) {
				result.add(p.joinToString(""))
			}
			return
		}
		var m = booleanArrayOf(false, false)
    var c = ' '
		for(k in i until p.size) {
			if (m[p[k] - '(']) {
				continue
			}
			if(p[k] == c) {
				continue
			}
			c = p[k]
			swap(p, i, k)
			generateParenthesisImpl(p, i+1, n, result)
			swap(p, i, k)
			m[p[k] - '('] = true
		}
	}

	fun generateParenthesis(n: Int): List<String> {
		var result = mutableListOf<String>()
		var p = CharArray(n * 2)
		for(i in 0 until n) {
			p[i] = '('
		}
		for(i in n until p.size) {
			p[i] = ')'
		}
		generateParenthesisImpl(p, 0, n * 2, result)
		return result
	}
}