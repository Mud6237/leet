// https://leetcode.com/problemset/all?search=68
// https://leetcode.com/problems/text-justification/

class Solution {
	fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
		var wordIndex = 0
		var result = mutableListOf<String>()
		while(wordIndex < words.size) {
			//println("Line: ")
			var lineStartIndex = wordIndex
			var lineLength = 0
			var lineWordIndex = lineStartIndex
			while(lineWordIndex < words.size) {
				var newLenth = lineLength + words[lineWordIndex].length + (lineWordIndex - lineStartIndex)
				lineLength += if (newLenth <= maxWidth) words[lineWordIndex].length else 0
				if (newLenth >= maxWidth) {
					lineWordIndex -= if (newLenth <= maxWidth) 0 else 1
					break
				}
				lineWordIndex += 1
			}
			lineWordIndex = Math.min(lineWordIndex, words.lastIndex)
			val lastLine = lineWordIndex == words.lastIndex
			var wordCount = (lineWordIndex - lineStartIndex) + 1
			var excessSpace = maxWidth - lineLength
			val evenSpace = if(lastLine) 1 else  excessSpace / Math.max(1, wordCount - 1) 
			val unEvenSpace = if (lastLine) 0 else excessSpace - (Math.max(1, wordCount - 1) * evenSpace)
			var sb = StringBuilder()

			//println("WordCount = $wordCount ")
			//println("ExcessSpace = ${excessSpace} ")
			//println("EvenSpace = ${evenSpace} ")
			//println("UnEvenSpace = ${unEvenSpace}")
			
			for(idx in lineStartIndex..lineWordIndex) {
				sb.append(words[idx])
				if (excessSpace > 0) {
					if (evenSpace > 0) {
						sb.append(" ".repeat(evenSpace))
						excessSpace -= evenSpace
					}
					if (idx - lineStartIndex < unEvenSpace) {
						sb.append(" ")
						excessSpace -= 1
					}
				}
			}
			if (excessSpace > 0) {
				sb.append(" ".repeat(excessSpace))
			}
			result.add(sb.toString())
			wordIndex = lineWordIndex + 1
		}
		return result
	}
}

fun main() {
	val words = arrayOf("What","must","be","acknowledgment","shall","be")
	val maxWidth = 16
	val res =  Solution().fullJustify(words, maxWidth)
	//val words = arrayOf("Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do")
	//val maxWidth = 20
	//val res =  Solution().fullJustify(words, maxWidth)
	res.forEach { println("[${it}]") }
}
