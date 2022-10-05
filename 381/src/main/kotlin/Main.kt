//https://leetcode.com/problemset/all?search=381
//https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
import kotlin.random.Random
class RandomizedCollection() {
	private val indexMap = hashMapOf<Int, MutableList<Int>>()
	private val itemList = mutableListOf<Int>()

	fun insert(`val`: Int): Boolean {
		val itemIndex = itemList.lastIndex
		itemList.add(`val`)
		val indexList = indexMap.getOrPut(`val`, { mutableListOf() })
		val exists = indexList.isEmpty()
		indexList.add(itemIndex)
		return exists
	}

	fun remove(`val`: Int): Boolean {
		val indexList = indexMap[`val`] ?: return false
		val exists = indexList.isNotEmpty()
		if (exists) {
			val index = indexList.removeLast()
			val t = itemList[itemList.lastIndex]
			itemList[itemList.lastIndex] = itemList[index]
			itemList[index] = t
			itemList.removeLast()
			if (itemList.isNotEmpty()) {
				val idxList = indexMap[t]
				if (idxList != null) {
					idxList[idxList.lastIndex] = index
				}
			}
		}
		return exists
	}

	fun getRandom(): Int {
		val r = Random.nextInt(0, itemList.size)
		return itemList[r]
	}

}

fun main() {
	println("Hello World!")
}
