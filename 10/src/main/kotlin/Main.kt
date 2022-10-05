// https://leetcode.com/problemset/all?search=10
// https://leetcode.com/problems/regular-expression-matching/
// https://swtch.com/~rsc/regexp/regexp1.html

class RegExp {
	companion object {
		const val Alternation_Precedence = 0
		const val Contactenation_Precedence = 1
		const val Repeation_Precedence = 2
		const val AnyMatch_Precedence = 3
		fun precedence(c: Char) : Int {
			return when(c) {
				'|' -> Alternation_Precedence
				'#' -> Contactenation_Precedence
				'?', '*', '+' -> Repeation_Precedence
				'.' -> AnyMatch_Precedence
				else -> Int.MAX_VALUE
			}
		}
		fun isBraces(c: Char): Boolean {
			return c == '(' || c == ')'
		}

		fun isRepeatationOperator(c: Char): Boolean {
			return c == '?' || c == '*' || c == '+'
		}

		fun isPureOperator(c: Char): Boolean {
			return c == '|' || c == '.' || isRepeatationOperator(c)
		}

		fun isOperator(c: Char): Boolean {
			return c == '#' || isPureOperator(c)
		}

		fun isLiteral(c: Char): Boolean {
			return !isOperator(c) && !isBraces(c)
		}
	}
	
	fun toPostFix(pattern: String): List<Char> {
		val result = mutableListOf<Char>()
		val stack = mutableListOf<Char>()
		var i = 0
		var l = '('
		while(i < pattern.length) {
			var c = pattern[i]
			if (!isRepeatationOperator(c) && c != ')' && l != '(' ) {
				c = '#'
			}
			repeat(if (c == '#') 2 else 1) {
				if(isOperator(c) || c == '(') {
					while(stack.isNotEmpty() && isOperator(stack.last()) && precedence(stack.last()) >= precedence(c)) {
						result.add(stack.removeLast())
					}
					stack.add(c)
				} else if (c == ')')  {
					while(stack.isNotEmpty() && stack.last() != '(') {
						result.add(stack.removeLast())
					}
					stack.removeLast()
				} else {
					result.add(c)
				}
				c = pattern[i]
			}
			l = c
			i += 1
		}
		while(stack.isNotEmpty()) {
			result.add(stack.removeLast())
		}
		return result
	}

	val SplitChar = Char.MAX_VALUE - 1
	val MatchState = State(Char.MAX_VALUE)

	class Edge(var s: State? = null)
	class State(var c: Char, var next1: Edge = Edge(), var next2: Edge = Edge())
	class Frag(var start: State, var `out`: MutableList<Edge>)

	fun toNFA(postFix: List<Char>): State {
		val stack = mutableListOf<Frag>()
		for(c in postFix) {
			if (isLiteral(c) || c == '.') {
				val s = State(c)
				stack.add(Frag(start = s, `out` = mutableListOf(s.next1)))
				continue
			}
			when(c) {
				'#' -> {
					val right = stack.removeLast()
					val left = stack.removeLast()
					left.`out`.forEach { edge -> edge.s = right.start }
					stack.add(Frag(start = left.start, `out` = right.`out`))
				}
				'|' -> {
					val right = stack.removeLast()
					val left = stack.removeLast()
					val s = State(SplitChar, next1 = Edge(left.start), next2 = Edge(right.start))
					val o = mutableListOf<Edge>().apply {
						addAll(left.`out`)
						addAll(right.`out`)
					}
					stack.add(Frag(s, o))
				}
				'?' -> {
					val top = stack.removeLast()
					val s = State(SplitChar, next1 = Edge(top.start))
					val o = mutableListOf<Edge>().apply {
						addAll(top.`out`)
						add(s.next2)
					}
					stack.add(Frag(s, o))
				}
				'*' -> {
					val top = stack.removeLast()
					val s = State(SplitChar, next1 = Edge(top.start))
					top.`out`.forEach {edge -> edge.s = s}
					val o = mutableListOf(s.next2)
					stack.add(Frag(s, o))
				}
				'+' -> {
					val top = stack.removeLast()
					val s = State(SplitChar, next1 = Edge(top.start))
					top.`out`.forEach{ edge -> edge.s = s }
					val o = mutableListOf(s.next2)
					stack.add(Frag(top.start, o))
				}
			}
		}
		//println("stack size ${stack.size}")
		val r = stack.removeLast()
		r.`out`.forEach { edge -> edge.s = MatchState }
		return r.start
	}

	fun compile(pattern: String): State {
		val postFix = toPostFix(pattern)
		val nfa = toNFA(postFix)
		return nfa
	}

	fun addState(l: MutableList<State>, s: State?) {
		val state = s ?: return
		if (s.c == SplitChar) {
			addState(l, s.next1.s)
			addState(l, s.next2.s)
		} else {
			l.add(s)
		}
	}

	fun test(nfa: State, s: String): Boolean {
		var currentList = mutableListOf<State>()
		addState(currentList, nfa)
		var nextList = mutableListOf<State>()
		for(c in s) {
			for(state in currentList) {
				//println("matching $c with ${state.c}")
				if (state.c == c || state.c == '.') {
					addState(nextList, state.next1.s)
				}
			}
			val t = nextList
			nextList = currentList
			currentList = t
		}
		for(state in currentList) {
			if ( state.c == MatchState.c ) {
				return true
			}
		}
		return false
	}
}

class Solution {
	fun isMatch(s: String, p: String): Boolean {
		val regexp = RegExp()
		val nfa = regexp.compile(p)
		//println(nfa.c)
		//println(nfa.next1.s?.c)
		//println(nfa.next1.s?.next1?.s?.c?.toInt())
		//println(nfa.next1.s?.next1?.s?.next1?.s?.c == RegExp().SplitChar)
		return regexp.test(nfa, s)
	}
}

fun main(args: Array<String>) {
	//println(Solution().isMatch("abbba", "a(bb)+.*"))
	//println(Solution().isMatch("aa", "a"))
	//println(Solution().isMatch("aa", "a"))
	//println(Solution().isMatch("a", "a"))
	//println(Solution().isMatch("aa", "a"))
	//println(Solution().isMatch("ab", ".*"))
	println(Solution().isMatch("aa", "a*"))
}
