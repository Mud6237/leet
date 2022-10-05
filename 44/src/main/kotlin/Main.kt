//https://leetcode.com/problemset/all?search=44
// https://leetcode.com/problems/wildcard-matching/
class Solution {

	class State(
		val c: Char,
		var next1: State? = null,
		var next2: State? = null
	)

	val finalState = State('#')

	fun toNFA(p: String): State? {
		val head = State(' ')
		var prev = head
		for(c in p) {
			val n = State(c)
			if (c == '*') {
				n.next1 = State('?', n)
			}
			if (prev.c == '*') {
				prev.next2 = n
			} else {
				prev.next1 = n
			}
			prev = n
		}
		prev.next1 = finalState
		return head.next1
	}

	fun addNextState(state: State?, l: MutableList<State>) {
		val s = state ?: return
		if (s.c == '*') {
			addNextState(s.next1, l)
			addNextState(s.next2, l)
		} else {
			l.add(s)
		}
	}

	fun isMatch(s: String, p: String): Boolean {
		val head = toNFA(p)
		var currentList = mutableListOf<State>()
		var nextList = mutableListOf<State>()
		addNextState(head, currentList)
		for(c in s) {
			for(state in currentList) {
				if (state.c == c || state.c == '?') {
					addNextState(state.next1, nextList)
				}
			}
			val t = nextList
			nextList = currentList
			currentList = t
		}
		for(state in currentList) {
			if (state === finalState) {
				return true
			}
		}
		return false
	}
}
fun main() {
	println("Hello World!")
}
