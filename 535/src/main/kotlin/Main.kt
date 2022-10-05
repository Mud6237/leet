// https://leetcode.com/problemset/all?search=535
import java.math.BigInteger
class Codec() {
	private var c = BigInteger("0")
	private val offset = BigInteger("1")
	private var h = hashMapOf<Int, Pair<String, String>>()
	private var cMap = hashMapOf<String, Pair<String, String>>()
  // Encodes a URL to a shortened URL.
	fun encode(longUrl: String): String {
		val hc = longUrl.hashCode()
		val u = h[hc]
		if (u != null) {
			return u.second
		}
		c = c.add(offset)
		var k = c.toString()
		var r = Pair(longUrl, k)
		h[hc] = r
		cMap[k] = r
		return k
	}

	// Decodes a shortened URL to its original URL.
	fun decode(shortUrl: String): String {
		val u = cMap[shortUrl]
		if (u != null) {
			return u.first
		}
		throw Throwable("Not found")
	}
}

fun main() {
	val c = Codec()
	println(c.encode("https://leetcode.com/problems/encode-and-decode-tinyurl/"))
	println(c.encode("https://leetcode.com/problems/encode-and-decode-tinyurl/"))
	println(c.decode("1"))
}
