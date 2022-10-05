// https://leetcode.com/problemset/all?search=843
// https://leetcode.com/problems/guess-the-word/

import kotlin.random.Random

interface Master {
	val secret : String
	fun guess(word: String): Int {
		return Solution.countCharMatch(secret, word)
	}
}

class Solution {
	companion object {
		fun countCharMatch(a: String, b: String): Int {
			val  len = Math.min(a.length, b.length) 
			var m = 0
			for(i in 0 until len) {
				if (a[i] == b[i]) {
					m += 1
				}
			}
			return m
		}
		fun Array<String>.swap(i: Int, j: Int) {
			val t = this[i]
			this[i] = this[j]
			this[j] = t
		}
	}
	fun findSecretWord(wordlist: Array<String>, master: Master) {
		var wordListIndex = wordlist.lastIndex
		for(i in 0 until 10) {
			val randIndex = Random.nextInt(0, wordListIndex + 1)
			val word = wordlist[randIndex]
			val match = master.guess(word)
			if (match == 6) {
				return
			}
			println("Guessed $word, match = $match")
			wordlist.swap(randIndex, wordListIndex)
			var j = 1
			var k = 0
			while(k <= wordListIndex - j) {
				val m = countCharMatch(wordlist[k], word)
				if (m < match) {
					wordlist[k] = wordlist[wordListIndex - j]
					j += 1
					k -= 1
				}
				k += 1
			}
			wordListIndex -= j
			println("j = $j wordListIndex = ${wordListIndex}")
			println(wordlist.toList())
		}
	}
}



fun main() {
	var wordlist = arrayOf("acckzz","ccbazz","eiowzz","abcczz")
	Solution().findSecretWord(wordlist, object: Master { override val secret = "acckzz" } )
	wordlist = arrayOf("hamada","khaled")
	Solution().findSecretWord(wordlist, object: Master { override val secret = "hamada" } )
}
