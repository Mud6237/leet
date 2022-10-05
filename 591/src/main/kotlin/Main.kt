// https://leetcode.com/problemset/all?search=591
// https://leetcode.com/problems/tag-validator/
class Solution {
	companion object {
		fun isTagNameLengthValid(start: Int, end: Int): Boolean {
			val d = end - start
			if (d > 0 && d < 10) {
				return true
			}
			return false
		}
		fun isUpperCase(c: Char) : Boolean {
			return c >= 'A' && c <= 'Z'
		}
		fun isStartOfCdata(s: Int, code: String): Boolean {
			var i = s
			var j = 0
			val cdataExp = "[CDATA["
			while(s < code.length && j < cdataExp.length) {
				if (code[i] != cdataExp[j]) {
					return false
				}
				i += 1
				j += 1
			}
			return true
		}

		fun isCDataEnd(s: Int, e: Int, code: String): Boolean {
			var cDataEndSeq = "]]>"
			var j = 0
			for(i in (s..e)) {
				if(code[i] != cDataEndSeq[j]) {
					return false
				}
				j += 1
			}
			return j == cDataEndSeq.length
		}

		fun match(startToken: Solution.Token, endToken: Solution.Token, code: String): Boolean {
			if (endToken.end - endToken.begin != startToken.end - startToken.begin) {
				return false
			}
			val l = (startToken.end - startToken.begin)
			for(i in 0..l) {
				if (code[startToken.begin + i] != code[endToken.begin + i]) {
					return false
				}
			}
			return true
		}

	}
	sealed class Token(val begin: Int, val end: Int) {
		class StartTag(val startIndex: Int, endIndex: Int): Token(startIndex, endIndex)
		class EndTag(val startIndex: Int, endIndex: Int): Token(startIndex, endIndex)
		class TagContent(val startIndex: Int, endIndex: Int): Token(startIndex, endIndex)
		class CData(val startIndex: Int, endIndex: Int): Token(startIndex, endIndex)
		class CDataContent(val startIndex: Int, endIndex: Int): Token(startIndex, endIndex)
	}

	fun parse(code: String): List<Token> {
		val result = mutableListOf<Token>()
		var charIndex = 0
		var contentStartIndex = 0
		mainloop@while(charIndex < code.length) {
			val isStartOfOpeningTag = code[charIndex] == '<'
			if (isStartOfOpeningTag) {
				if( charIndex - contentStartIndex > 0) {
					result.add(Token.TagContent(contentStartIndex, charIndex - 1))
					contentStartIndex = charIndex
				}
				var isTagStart = charIndex + 1 < code.length && code[charIndex + 1] != '!'
				var isCDataStart = charIndex + 1 < code.length && code[charIndex + 1] == '!'
				if (isTagStart) {
					var tagNameStartIndex = charIndex + 1
					var isClosingTag = false
					var tagNameIndex = tagNameStartIndex
					var isUpperCaseOnly = true
					if (tagNameIndex < code.length && code[tagNameIndex] == '/') {
						tagNameIndex += 1
						isClosingTag = true
						tagNameStartIndex = tagNameIndex
					}
					while(tagNameIndex < code.length && code[tagNameIndex] != '>') {
						isUpperCaseOnly = isUpperCaseOnly && isUpperCase(code[tagNameIndex]) 
						tagNameIndex += 1
					}
					var tagNameLengthValid = isTagNameLengthValid(tagNameStartIndex, tagNameIndex)
					if ( tagNameIndex >= code.length || code[tagNameIndex] != '>' || !tagNameLengthValid || !isUpperCaseOnly ) {
						break@mainloop
					}
					if (isClosingTag) {
						result.add(Token.EndTag(tagNameStartIndex, tagNameIndex - 1))
					} else {
						result.add(Token.StartTag(tagNameStartIndex, tagNameIndex - 1))
					}
					contentStartIndex = tagNameIndex + 1
					charIndex = tagNameIndex
				} else if (isCDataStart) {
					var cDataStartIndex = charIndex + 2
					var cDataContentStart = cDataStartIndex + 7
					if (isStartOfCdata(cDataStartIndex, code)) {
						var cDataContentTailIndex = cDataContentStart
						var cDataContentHeadIndex = cDataContentStart + 2
						var cDataContentEnd = false
						while(cDataContentHeadIndex < code.length && !cDataContentEnd ) {
							cDataContentEnd = isCDataEnd(cDataContentTailIndex, cDataContentHeadIndex, code) 
							cDataContentTailIndex +=1
							cDataContentHeadIndex +=1
						}
						if (cDataContentEnd) {
							result.add(Token.CDataContent(cDataContentStart, cDataContentTailIndex - 2))
							charIndex = cDataContentHeadIndex - 1
							contentStartIndex = charIndex + 1
						}
					} 
				}
			}
			charIndex += 1
		}
		return result
	}

	fun printToken(tokens: List<Token>, code: String) {
		tokens.forEach { token  ->  when(token) {
				is Token.StartTag -> println("<${code.substring(token.begin, token.end + 1)}>") 
				is Token.EndTag -> println("</${code.substring(token.begin, token.end + 1)}>") 
				is Token.TagContent -> println("TagContent : ${code.substring(token.begin, token.end + 1)}") 
				is Token.CDataContent -> println("CDataContent : ${code.substring(token.begin, token.end + 1)}") 
				else  -> println("Other : ${code.substring(token.begin, token.end + 1)}") 
			}
		}
	}

	fun isValid(code: String): Boolean {
		val tokens = parse(code)
		val stack = mutableListOf<Token>()
		mainloop@for(token in tokens) {
			when(token) {
				is Token.EndTag -> {
					while(stack.isNotEmpty()) {
						val top = stack.removeLast()
						if (top is Token.StartTag) {
							if (match(top, token, code)) {
								break
							} else {
								break@mainloop
							}
						}
					}
				}
				else -> {
					stack.add(token)
				}
			}
		}
		return stack.size == 0
	}
}
fun main() {
	//val code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>"
	//val code = "<DIV>This is the first line <![CDATA[<div>]]></DIV>"
	val code = "<A>  <B> </A>   </B>"
	println(Solution().isValid(code))
}
