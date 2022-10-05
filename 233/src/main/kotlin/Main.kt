//https://leetcode.com/problemset/all?search=233
//https://leetcode.com/problems/number-of-digit-one/
//  (nl / divider) * i  +  min(max((n mod (i*10))−i+1,0),i)

class Solution {
	fun countDigitOne(n: Int): Int {
			var countr = 0L;
			val nl = n.toLong()
			var i = 1L
			while(i <= nl) {
				val divider = i * 10
				countr += (nl / divider) * i + Math.min(Math.max(nl % divider - i + 1, 0L), i)
				i = divider
			}
			return countr.toInt();
	}
}