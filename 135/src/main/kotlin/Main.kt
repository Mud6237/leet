// https://leetcode.com/problemset/all?search=135

class Solution {
	fun candy(ratings: IntArray): Int {
		val l = MutableList(ratings.size, { 1 })
		for(i in 1..ratings.lastIndex) {
			if (ratings[i-1] < ratings[i]) {
				l[i] = l[i-1] + 1
			}
		}
		for(i in ratings.lastIndex-1 downTo 0) {
			if (ratings[i+1] < ratings[i] ) {
				l[i] = l[i+1] + 1
			}
		}
		return l.sum()
	}
}

fun main(args: Array<String>) {
	println("Hello World!")
}
