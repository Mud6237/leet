//https://leetcode.com/problemset/all?search=380
//https://leetcode.com/problems/insert-delete-getrandom-o1/

class RandomizedSet() {
	var a = mutableListOf<Int>()
	val h = hashMapOf<Int, Int>()

	fun insert(`val`: Int): Boolean {
		val i = h.getOrDefault(`val`, -1)
		if (i < 0) {
			a.add(`val`)
			h[`val`] = a.lastIndex
		}
		return i < 0
	}

	fun remove(`val`: Int): Boolean {
		val i = h.getOrDefault(`val`, -1)
		if (i >= 0) {
			val t = a[a.lastIndex]
			a[i] = t
			h[t] = i
			a.removeAt(a.lastIndex)
			h.remove(`val`)
		}
		return i >= 0
	}

	fun getRandom(): Int {
		val randomIndex = (0 until a.size).random()
		return a[randomIndex]
	}

}

