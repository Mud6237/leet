//https://leetcode.com/problems/all-oone-data-structure/

class AllOne1() {
	companion object {
		fun<T> MutableList<T>.removeLast(): T {
				return if (isEmpty()) throw NoSuchElementException("List is empty.") else removeAt(lastIndex)
		}
	}
	private var minKeyStack = mutableListOf<String>()
	private var minCount = 0
	private var maxCount = 0
	private var m = hashMapOf<String, Pair<Int, Int>>()
	private var c = hashMapOf<Int, MutableList<String>>()

	fun inc(key: String) {
		val (oldCount, oldIndex) = m[key] ?: Pair(0, 0)
		var oldCountListSize = 0
		if (oldCount > 0) {
			val oldCountList = c[oldCount] ?: return
			oldCountList[oldIndex] = oldCountList[oldCountList.lastIndex]
			oldCountList.removeLast()
			if (oldCountList.size > oldIndex) {
				m[oldCountList[oldIndex]] = Pair(oldCount, oldIndex)
			}
			oldCountListSize = oldCountList.size
		}
		val oldMinTopCount = c[minCount]?.size ?: Int.MAX_VALUE
		val newCount = oldCount + 1
		val newCountList = c.getOrPut(newCount,  { mutableListOf<String>() })
		newCountList.add(key)
		m[key] = Pair(newCount, newCountList.lastIndex)
		val minTopCount = m[minKeyStack.lastOrNull()]?.first ?: Int.MAX_VALUE
		if (oldCount == minCount && oldCountListSize == 0) {
			minCount = newCount
		} else {
			minCount = Math.min(minCount, newCount)
		}
		val cMinList = c[minCount]
		if (minCount < minTopCount || cMinList?.size  ?: Int.MAX_VALUE > oldMinTopCount) {
			val l = cMinList?.lastOrNull()
			if (l != null) {
				minKeyStack.add(l)
			}
		}
		//println("Inc: key = $key minKeyStack = $minKeyStack")
		maxCount = Math.max(maxCount, oldCount + 1)
	}

	fun dec(key: String) {
		val (oldCount, oldIndex) = m[key] ?: return
		val oldCountList = c[oldCount] ?: return
		oldCountList[oldIndex] = oldCountList[oldCountList.lastIndex]
		oldCountList.removeLast()
		if (oldCountList.size > oldIndex) {
			m[oldCountList[oldIndex]] = Pair(oldCount, oldIndex)
		}
		if (oldCount > 1) {
			val newCountList = c.getOrPut(oldCount - 1, { mutableListOf<String>()})
			newCountList.add(key)
			m[key] = Pair(oldCount-1, newCountList.lastIndex)
		} else {
			m.remove(key)
		}

		val minTopCount = m[minKeyStack.lastOrNull()]?.first ?: Int.MIN_VALUE
		if (oldCount - 1 < minTopCount) {
			val newTop = c[oldCount-1]?.lastOrNull()
			if (newTop != null) {
				minKeyStack.add(newTop)
			}
		} else {
			if (oldCount == 1) {
				minKeyStack.removeLast()
			}
		}

		if (maxCount == oldCount && oldCountList.size < 1) {
			maxCount = Math.max(0, maxCount - 1)
		}
		//println("Dec: key = $key minKeyStack = $minKeyStack")
	}

	fun getMaxKey(): String {
		return c[maxCount]?.lastOrNull() ?: ""
	}

	fun getMinKey(): String {
		var l = minKeyStack.lastOrNull() ?: return  ""
		if (m[l] == null) {
			l = ""
			minKeyStack = mutableListOf<String>()
		}
		return l
	}

}


class AllOne {
	companion object {
		fun<T> MutableList<T>.removeLast(): T {
				return if (isEmpty()) throw NoSuchElementException("List is empty.") else removeAt(lastIndex)
		}
	}
	val countMap = hashMapOf<Int, MutableList<String>>()
	val keyMap = hashMapOf<String, Pair<Int, Int>>()
	var minCount = 0
	var prevMinCount = 0
	var maxCount = 0

	fun inc(key: String) {
		val (oldCount, oldIndex) = keyMap.getOrDefault(key, Pair(0, -1))
		val oldList = countMap[oldCount]
		if (oldList != null &&  oldList.size > 0) {
			oldList[oldIndex] = oldList[oldList.lastIndex]
			oldList.removeLast()
			if (oldList.size > oldIndex) {
				keyMap[oldList[oldIndex]] = Pair(oldCount, oldIndex)
			}
		}
		val newCount = oldCount + 1
		val newList = countMap.getOrPut(newCount, { mutableListOf<String>() })
		newList.add(key)
		keyMap[key] = Pair(newCount, newList.lastIndex)
		// update min count
		var newMinCount: Int
		if (oldCount == minCount && (oldList?.isEmpty() ?: true)) {
			newMinCount = newCount
		} else {
			newMinCount = Math.min(minCount, newCount)
		}
		minCount = newMinCount
		if (oldCount == prevMinCount && (oldList?.isEmpty() ?: true)) {
			prevMinCount = newCount
		} else {
			if (prevMinCount > 0 && newMinCount != 1) {
				prevMinCount = Math.max(2, minCount)
			}
		}
		// update max count
		maxCount = Math.max(maxCount, newCount)
		println("+$key = MaxKey = ${getMaxKey()}, MinKey = ${getMinKey()} minCount = ${minCount} prevMinCount = ${prevMinCount} keyMap = ${keyMap}")
	}

	fun dec(key: String) {
		val (oldCount, oldIndex) = keyMap[key] ?: return
		val oldList = countMap[oldCount] ?: return
		oldList[oldIndex] = oldList[oldList.lastIndex]
		oldList.removeLast()
		if (oldList.size > oldIndex) {
			keyMap[oldList[oldIndex]] = Pair(oldCount, oldIndex)
		}
		val newCount = oldCount - 1
		val newList = countMap[newCount]
		if (newCount > 0 && newList != null)  {
			newList.add(key)
			keyMap[key] = Pair(newCount, newList.lastIndex)
		} else {
			keyMap.remove(key)
		}
		//if (oldCount == prevMinCount && oldList.isEmpty()) {
		//	prevMinCount  = prevMinCount + 1
		//}
		// update min count
		if (oldCount == minCount) {
			if (oldList.size == 0) {
				if (countMap[minCount - 1]?.isNotEmpty() ?: false) {
					minCount = minCount - 1
				} else {
					minCount = prevMinCount
				}
			}
		} else {
			minCount = Math.min(minCount, newCount)
		}
		// Update max count
		if (oldCount == maxCount && oldList.isEmpty()) {
			maxCount = newCount
		}
		println("-$key = MaxKey = ${getMaxKey()}, MinKey = ${getMinKey()} minCount = ${minCount} prevMinCount = ${prevMinCount} keyMap = ${keyMap}")
	}
	
	fun getMaxKey(): String {
		return countMap[maxCount]?.lastOrNull() ?: ""
	}

	fun getMinKey(): String {
		return countMap[minCount]?.lastOrNull() ?: ""
	}
	
}

fun main() {
	AllOne().apply {
		inc("b")
		inc("b")
		inc("b")
		inc("b")
		inc("b")
		inc("c")
		inc("c")
		inc("c")
		inc("c")
		inc("a")
		dec("a")
		dec("c")
		dec("c")
		dec("c")
		dec("c")
	}
	
}