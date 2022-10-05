//https://leetcode.com/problemset/all?search=68

class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        var wordIndex = 0
        var lines = mutableListOf<String>()
        var lineSb = StringBuilder()
        while(wordIndex < words.size) {
            var currentLineCharCount = 0
            var currentLineWordCount = 0
            var currentLineStartWordIndex = wordIndex;
            if (words[currentLineStartWordIndex].length >= maxWidth) {
                val word = words[currentLineStartWordIndex];
                val q = word.length / maxWidth
                var j = 0
                while(j < q) {
                    lines.add(word.substring(j*maxWidth, (j+1) * maxWidth))
										currentLineCharCount = maxWidth
                    j += 1
                }
                val overflow  = word.length % maxWidth
                if (overflow > 0) {
                    lineSb.append(word.substring(word.length - overflow, word.length))
                    currentLineWordCount = 1
                    currentLineCharCount = overflow
                }
                currentLineStartWordIndex += 1
            }
            var currentLineWordIndex = currentLineStartWordIndex;
            while(
                currentLineWordIndex < words.size &&
                words[currentLineWordIndex].length + currentLineCharCount + currentLineWordCount <= maxWidth
            ) {
                currentLineWordCount += 1
                currentLineCharCount += words[currentLineWordIndex].length
                currentLineWordIndex += 1
            }
            val remainingSpace = maxWidth - currentLineCharCount
            val lastLine = currentLineWordIndex >= words.size
            if (currentLineWordCount > 1) {
                val spaceSlots = currentLineWordCount - 1
                val spacePerSlot = if (!lastLine) remainingSpace / spaceSlots else 1
                var extraSpace = if (!lastLine) remainingSpace % spaceSlots else 0
                var space = currentLineStartWordIndex > wordIndex
                for(j in currentLineStartWordIndex until currentLineWordIndex) {
                    if (space) {
                        lineSb.append(" ".repeat(spacePerSlot))
                        if (extraSpace > 0) {
                            lineSb.append(" ")
                        }
                        extraSpace -= 1
                    }
                    space = true
                    lineSb.append(words[j])
                }
                if (lastLine) {
                    if (remainingSpace - spaceSlots > 0) {
                        lineSb.append(" ".repeat(remainingSpace - spaceSlots))
                    }
                }
            } else {
                words.slice(currentLineStartWordIndex until currentLineWordIndex).forEach { lineSb.append(it) }
                if (remainingSpace > 0) {
                    lineSb.append(" ".repeat(remainingSpace));
                }
            }
            val lineStr = lineSb.toString()
            if (lineStr.length > 0) {
                lines.add(lineStr)
            }
            lineSb.clear()
            wordIndex = currentLineWordIndex
        }
        return lines;
    }
}

fun main() {
    val words = arrayOf("This", "is", "an", "example", "of", "text", "justification.")
    val maxWidth = 16
    println(Solution().fullJustify(words, maxWidth));
    //println(Solution().fullJustify(words, maxWidth).map { it.length });
}
