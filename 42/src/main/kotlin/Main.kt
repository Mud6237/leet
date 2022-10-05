class Solution {
	fun trap(height: IntArray): Int {
		val left = height.copyOf()
		val right = height.copyOf()
		for(i in 1..left.lastIndex) {
			left[i] = Math.max(left[i], left[i-1])
		}
		for(j in right.lastIndex - 1 downTo 0 ) {
			right[j] = Math.max(right[j], right[j+1])
		}
		var result = 0
		for( i in 0 until height.size) {
			result += Math.min(left[i], right[i]) - height[i]
		}
		return result
	}
}
fun main(args: Array<String>) {
}
