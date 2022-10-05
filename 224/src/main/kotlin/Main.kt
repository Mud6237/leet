// https://leetcode.com/problemset/all?search=224

class Solution {
	companion object {
		fun plus(a: String, b: String): String {
			return "${a.toInt() + b.toInt()}"
		}
		fun minus(a: String, b: String): String {
			return "${a.toInt() - b.toInt()}"
		}
		fun minus(a: String): String {
			return "${a.toInt() * -1}"
		}
	}
	private enum class OperatorKind {
		Plus,
		BinaryMinus,
		UnaryMinus
	}
	private sealed class Token {
		class PlusOperand: Token()
		class Operator(val op: OperatorKind): Token()
		class Operand(val v: String): Token()
		class OpeningBracket() : Token()
		class ClosingBracket() : Token()
	}

	private fun tokenize(s: String): List<Token> {
		val tokens = mutableListOf<Token>()
		val emtpyOperand  = Token.OpeningBracket()
		var l: Token = emtpyOperand
		var d = ""
		for(c in s) {
			val t: Token = when(c) {
				' ' -> continue
				'(' -> Token.OpeningBracket()
				')' -> Token.ClosingBracket()
				'+' -> Token.Operator(OperatorKind.Plus)
				'-' -> if (l is Token.OpeningBracket) Token.Operator(OperatorKind.UnaryMinus) else Token.Operator(OperatorKind.BinaryMinus)
				else -> {
					d += c
					Token.Operand(d)
				}
			}
			if (t !is Token.Operand) {
				if (l is Token.Operand) {
					tokens.add(l)
					d = ""
				}
				tokens.add(t)
			}
			l = t
		}
		if (l is Token.Operand) {
			tokens.add(l)
		}
		return tokens
	}

	private fun printTokens(tokens: List<Token>): String {
		val sb = StringBuilder()
		for(t in tokens) {
			when(t){
				is Token.Operator -> if (t.op == OperatorKind.Plus) sb.append("+") else {
					if (t.op == OperatorKind.UnaryMinus) {
						sb.append("-")	
					} else {
						sb.append(" - ")
					}
				}
				is Token.Operand -> sb.append(t.v)
				is Token.OpeningBracket -> sb.append("(")
				is Token.ClosingBracket -> sb.append(")")
			}
		}
		return sb.toString()
	}

	private fun toPostFix(tokens: List<Token>) : MutableList<Token> {
		val result = mutableListOf<Token>()
		val stack = mutableListOf<Token>()
		for(t in tokens) {
			when(t) {
				is Token.Operator, is Token.OpeningBracket -> {
					while(stack.isNotEmpty() && t is Token.Operator) {
						val l = stack.last() 
						if (l is Token.Operator && l.op >= t.op) {
							result.add(stack.removeLast())
						} else {
							break
						}
					}
					stack.add(t)
				}
				is Token.ClosingBracket -> {
					while(stack.isNotEmpty() && stack.last() !is Token.OpeningBracket) {
						result.add(stack.removeLast())
					}
					stack.removeLast()
				}
				else -> result.add(t)
			}
		}
		while(stack.isNotEmpty()) {
			result.add(stack.removeLast())
		}
		return result
	}

	private fun evaluate(postfix: MutableList<Token>): Int {
		val stack = mutableListOf<Token>()
		val postfixStack = postfix.asReversed()
		//println(printTokens(postfixStack))
		while(postfixStack.isNotEmpty()) {
			when(val t = postfixStack.removeLast()) {
				is Token.Operand -> stack.add(t)
				is Token.Operator -> {
					val r = stack.removeLast() as Token.Operand
					stack.add(when(t.op) {
						OperatorKind.UnaryMinus -> Token.Operand(minus(r.v))
						OperatorKind.BinaryMinus -> {
							val l = stack.removeLast() as Token.Operand
							Token.Operand(minus(l.v, r.v))
						}
						OperatorKind.Plus -> {
							val l = stack.removeLast() as Token.Operand
							Token.Operand(plus(l.v, r.v))
						}
					})
				}
			}
		}
		val result =  stack.removeLast() as Token.Operand
		return result.v.toInt()
	}

	fun calculate(s: String): Int {
		val tokens = tokenize(s)
		val postfix = toPostFix(tokens)
		return evaluate(postfix)
	}
}



fun main(args: Array<String>) {
	println(Solution().calculate("1 + 1"))
	println(Solution().calculate(" 2-1 + 2 "))
	println(Solution().calculate("(1+(4+5+2)-3)+(6+8)"))
	println(Solution().calculate("-2 - 2"))
	println(Solution().calculate("-(2 + 3)"))
	println(Solution().calculate("(-2) -(-2)"))
	println(Solution().calculate("-(-2) -(-2)"))
	println(Solution().calculate("2 + (2 -(-3))"))
}
