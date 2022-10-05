//https://leetcode.com/problems/wildcard-matching/
class Solution {
	class State(
		val c: Char,
		var out: State?,
		var out1: State? = null,
		var lastList: Int = 0
	) {
		override fun toString(): String {
			return "State(c = $c, out = ${out?.c ?: "null"}, out1=${out1?.c ?: "null"} lastList = ${lastList})"
		}
	}

	private fun toNFA(tokens: MutableList<Char>): State {
		val matchState = State('$', null)
		var beforeHead = State('?', matchState)
		var prev = beforeHead
		var prePrev = beforeHead
		for(c in tokens) {
			val s = State(c, matchState)
			if(c == '*') {
				s.out = prev
				s.out1 = matchState
				prePrev.out = s
			}
			if (prev.c == '*') {
				prev.out1 = s
			} else {
				prev.out = s
			}
			prePrev = prev
			prev = s
		}
		return beforeHead.out!!
	}

	private fun addState(state: State?, list: MutableList<State>, listId: Int) {
		state ?: return
		if (state.lastList == listId) {
			return
		}
		state.lastList = listId
		if (state.c == '*') {
			addState(state.out, list, listId)
			addState(state.out1, list, listId)
		}
		list.add(state)
	}

	fun isMatch(s: String, p: String): Boolean {
		val tokens = mutableListOf<Char>()
		for(c in p) {
			if (c == '*') {
				if (tokens.isNotEmpty() && tokens.last() == '*') {
					continue
				}
				tokens.add('?')
			} 
			tokens.add(c)
		}
		val nfa = toNFA(tokens)
		//println(nfa)
		var currentList = mutableListOf<State>()
		var listId = 1
		addState(nfa, currentList, listId)
		for(c in s) {
			val nextList = mutableListOf<State>()
			listId += 1
			for(state in currentList) {
				if ((state.c == c) || (state.c == '?')) {
					addState(state.out, nextList, listId)
				}
			}
			if (nextList.isEmpty()) {
				return false
			}
			currentList = nextList
		}
		for(state in currentList) {
			if(state.c == '$') {
				return true
			}
		}
		return false
	}

}