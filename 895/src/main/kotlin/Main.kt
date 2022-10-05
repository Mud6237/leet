//https://leetcode.com/problemset/all?search=895
class FreqStack() {
	val countMap = hashMapOf<Int, Int>()
	val elementMap = hashMapOf<Int, ArrayDeque<Int>>()
	var maxCount = Int.MIN_VALUE
	fun push(`val`: Int) {
		val count = countMap.getOrDefault(`val`, 0) + 1
		countMap[`val`] = count
		val deque = elementMap.getOrPut(count, { ArrayDeque<Int>() })
		deque.addLast(`val`)
		maxCount = Math.max(maxCount, count)
	}

	fun pop(): Int {
		//println("maxcount $maxCount")
		val deque = elementMap[maxCount]
		val r = deque!!.removeLast()
		maxCount = if(deque.size == 0) maxCount -1 else maxCount
		return r
	}
}
fun main(args: Array<String>) {
	println("Hello World!")
}
