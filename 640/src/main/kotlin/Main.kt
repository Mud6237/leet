//https://leetcode.com/problemset/all?search=640
//https://leetcode.com/problems/solve-the-equation/
class Solution {
	fun tokenize(s: String): Pair<MutableList<Int>, MutableList<Int>> {
		val constants = mutableListOf<Int>()
		val coefficients = mutableListOf<Int>()
		var i = 0
		var c = false
		var n = 1
		var j = 0

		val f = { x: Int, y: Int ->
			var k = if(c) y-1 else y
			val str = s.substring(x, k)
			if (c) {
				if (str.length > 0) {
					coefficients.add(str.toInt() * n)
				} else {
					coefficients.add(1 * n)
				}
			} else {
				if (str.length > 0) {
					constants.add(str.toInt() * n)
				}
			}
			Unit
		}

		while(j < s.length) {
			if(s[j] == 'x'){
				c = true
			}
			if (s[j] == '-' || s[j] == '+') {
				f(i, j)
				if(s[j] == '-'){
					n = -1
				} else {
					n = 1
				}
				i = j + 1
				c = false
			}
			j += 1
		}
		f(i, j)
		return Pair(constants, coefficients)
	}

	fun solveEquation(equation: String): String {
		val(lhs, rhs) = equation.split('=')
		val (lhsConstants, lhsCoefficients) = tokenize(lhs)
		val (rhsConstants, rhsCoefficients) = tokenize(rhs)
		val lhsConstantsSum = lhsConstants.sum()
		val rhsConstantsSum = rhsConstants.sum()
		val lhsCoefficientsSum = lhsCoefficients.sum()
		val rhsCoefficientsSum = rhsCoefficients.sum()
		val constants = rhsConstantsSum + (lhsConstantsSum * -1)
		val coefficients = lhsCoefficientsSum + (rhsCoefficientsSum * -1)
		//println(lhsConstants)
		//println(lhsCoefficients)
		//println(rhsConstants)
		//println(rhsCoefficients)
		if (lhsCoefficientsSum == rhsCoefficientsSum && lhsConstantsSum == rhsConstantsSum) {
			return "Infinite solutions"
		}
		if (coefficients != 0 &&  constants % coefficients == 0) {
			return "x=${constants / coefficients}"
		} 
		return "No solution"
	}
}

fun main() {
	println(Solution().solveEquation("x+5-3+x=6+x-2"))
	println(Solution().solveEquation("x=x"))
	println(Solution().solveEquation("2x=x"))
	println(Solution().solveEquation("2x=4"))
	println(Solution().solveEquation("2x=7"))
	println(Solution().solveEquation("0=1"))
	println(Solution().solveEquation("1=0"))
	println(Solution().solveEquation("1=1"))
	println(Solution().solveEquation("1=10"))
	println(Solution().solveEquation("2x+3x-6x=x+2"))
	println(Solution().solveEquation("-x=-1"))
	println(Solution().solveEquation("x=1"))
	println(Solution().solveEquation("2x=2x"))
	println(Solution().solveEquation("1=1"))
}
