//https://leetcode.com/problemset/all?search=43
class Solution {
	fun add(a: IntArray, b: IntArray): IntArray {
		var r = IntArray(Math.max(a.size, b.size) + 1)
		var c = 0
		var i = 0
		val al = a.lastIndex
		val bl = b.lastIndex
		var rl = r.lastIndex
		var j = Math.min(al, bl)
		while(i <= j) {
			val s = a[al - i] + b[bl - i] + c
			r[rl - i] = s % 10
			c = s / 10
			i += 1
		}
		while(i <= al) {
			val s = a[al-i] + c
			r[rl-i] = s % 10
			c = s / 10
			i += 1
		}
		while(i <= bl) {
			val s = b[bl-i] + c
			r[rl-i] = s % 10
			c = s / 10
			i += 1
		}
		if (c > 0) {
			r[0] = c
		}
		return r
	}

	fun multiply(num1: String, num2: String): String {
		var a = num1
		var b = num2
		if(num2.length > num1.length) {
			a = num2
			b = num1
		}
		var r = IntArray(a.length)
		for(j in b.lastIndex downTo 0) {
			var x = b[j] - '0'
			var c = 0
			var q = IntArray(a.length + (b.lastIndex - j) + 1)
			for(i in a.lastIndex downTo 0) {
				var y = a[i] - '0'
				var p = (x * y) + c
				q[i+1] = p % 10
				c = p / 10
			}
			if (c > 0) {
				q[0] = c
			}
			r = add(q, r)
		}
		var k = 0
		while(k < r.size) {
			if (r[k] > 0) {
				break
			}
			k += 1
		}
		val str =  r.slice(k until r.size).joinToString("")
		if(str.length < 1) {
			return "0"
		} else {
			return str
		}
	}
}
