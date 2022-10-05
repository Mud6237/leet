//https://leetcode.com/problems/nth-magical-number/
class Solution {
	private tailrec fun gcd(a: Long, b: Long): Long {
		if (b == 0L){
			return a
		} else {
			return gcd(b, a % b)
		}
	}
	
	fun nthMagicalNumber(n: Int, a: Int, b: Int): Int {
		val m = 1_000_000_007
		var al = a.toLong()
		val bl = b.toLong()
		var nl = n.toLong()

		val g = gcd(al, bl)
		val lcm = (al * bl) / g
		var l = Math.min(al, bl)
		var h = nl * Math.min(al, bl)
		while(l < h) {
			val mid = l +  (h - l) / 2
			val c = (mid / al) + (mid / bl) - (mid / lcm)
			if (c < n) {
				l = mid + 1
			} else {
				h = mid
			}
		}
		return (l % m).toInt()
	}
}