// https://leetcode.com/problemset/all?search=352
// https://leetcode.com/problems/data-stream-as-disjoint-intervals/

class WeightedUnion(val n: Int, val a: IntArray = IntArray(n+1, { - 1 }), val s: IntArray = IntArray(n+1, { 0 })) {
	fun find(n: Int): Int {
		return a[n]
	}

	fun size(): Int {
		return a.size - 1
	}

	fun root(i: Int): Int {
		var j = i
		while(j != a[j]) {
			a[j] = a[a[j]] // Path Compression 
			j = a[j]
		}
		return j
	}

	fun union(x: Int, y: Int) {
		if (find(x) < 0) {
			a[x] = x
			s[x] = 1
		}
		if (find(y) < 0) {
			a[y] = y
			s[y] = 1
		}
		val xRoot = root(x)
		val yRoot = root(y)
		if (s[xRoot] <= s[yRoot]) {
			a[x] = yRoot
			//a[xRoot] = yRoot
			s[yRoot] += s[xRoot]
		} else {
			//a[yRoot] = xRoot
			a[y] = xRoot
			s[xRoot] += s[yRoot]
		}
	}
}

class QickUnion(val n: Int, val a: IntArray = IntArray(n + 1, { - 1 })) {
	fun find(n: Int) : Int {
		return a[n]
	}

	fun root(i: Int): Int {
		var j = i
		while(j != a[j]) { 
			j = a[j] 
		}
		return j
	}

	fun union(x: Int, y: Int) {
		if (find(x) < 0) {
			a[x] = x
		}
		if (find(y) < 0) {
			a[y] = y
		}
		a[x] = root(y)
	}

	fun size(): Int {
		return a.size - 1
	}

}

/*Quick Find Variant*/
class QuickFind(val maxValue: Int, private val a: IntArray = IntArray(maxValue + 1, { -1 })) {
	fun find(n: Int): Int {
		return a[n]
	}

	fun union(x: Int, y: Int) {
		if (find(x) < 0) {
			a[x] = x
		}
		if (find(y) < 0) {
			a[y] = y
		}
		if (x == y) {
			return
		}
		val yRoot = a[y]
		val xRoot = a[x]
		//print("xRoot = $xRoot, yRoot == $yRoot")
		for(i in 0 until a.size) {
			if (a[i] == yRoot) {
				a[i] = xRoot
				//println("i = $i a[i] = ${a[i]}")
			}
		}
		//println("a[0] = ${a[0]} a[1] = ${a[1]} a[2] = ${a[2]} ")
	}
	
	fun size(): Int {
		return a.size - 1
	}

}

class SummaryRanges() {
	val uf = WeightedUnion(10_000)
	fun addNum(`val`: Int) {
		val exists = uf.find(`val`) >= 0
		if (!exists) {
			val lowerExists = if (`val` > 0) uf.find(`val` - 1 ) >= 0 else false
			val higherExists = if (`val` < uf.size() - 1) uf.find(`val` + 1) >= 0 else false
			if (lowerExists) {
				uf.union(`val` - 1, `val`)
			} 
			if(higherExists) {
				uf.union(`val`, `val` + 1)
			}
			if (!lowerExists && !higherExists) {
				uf.union(`val`, `val`)
			}
		}
	}

	fun getIntervals(): Array<IntArray> {
		val r = mutableListOf<IntArray>()
		val m = uf.size()
		var prev = -1
		for(i in 0..m) {
			if (uf.find(i) >= 0) {
				val iRoot = uf.root(i)
				if (iRoot != prev) {
					r.add(intArrayOf(i, i))
				}
				r[r.lastIndex][1] = i
				prev = iRoot
			}
		}
		return r.toTypedArray()
	}
}

fun printS(s: SummaryRanges) {
	//print(s.uf.a.slice(0..10).toList())
	s.getIntervals().forEach{ print(it.toList()) }
	println()
}

fun main() {
	val s = SummaryRanges()
	s.addNum(1)
	printS(s)
	s.addNum(3)
	printS(s)
	s.addNum(7)
	printS(s)
	s.addNum(2)
	printS(s)
	s.addNum(6)
	printS(s)
	s.addNum(0)
	printS(s)
	s.addNum(0)
	printS(s)
	s.addNum(10000)
	printS(s)

}
