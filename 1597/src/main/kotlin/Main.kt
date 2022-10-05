// https://leetcode.com/problemset/all?search=1597
// https://leetcode.com/problem/build-binary-expression-tree-from-infix-expression/
<<<<<<< Updated upstream
/* Definition for a binary tree node. */

class Node(
	var `val`: Char = ' ',
	var left: Node? = null,
	var right: Node? = null,
)
class Solution {
	companion object {
		// [ "(", ")", "*", "+", ",", "-", ".", "/" ] 
		val OpPrecedence = intArrayOf(6, 6, 4, 2, 0, 3, 0, 5)
		fun precedence(c: Char): Int {
			return OpPrecedence[(c - '(').toInt()]
		}
		fun isOperator(c: Char): Boolean {
			return c == '+' || c == '-' || c == '*' || c == '/'
		}
		fun isOperand(c: Char): Boolean {
			return c >= '0' && c <= '9'
		}
	}

	fun toPostFix(s: String): MutableList<Char> {
		val postFix = mutableListOf<Char>()
		val tokens = s.toCharArray()
		val stack = mutableListOf<Char>()
		for(token in tokens) {
			if (token == ' ') {
				continue
			}
			if(isOperand(token)) {
				postFix.add(token)
			}else if (token == '(' ) {
				stack.add(token)
			} else if (isOperator(token)) {
				while(stack.isNotEmpty() && isOperator(stack.last()) && precedence(stack.last()) >= precedence(token)) {
					postFix.add(stack.removeLast())
				}
				stack.add(token)
			} else if (token == ')') {
				while(stack.isNotEmpty() && stack.last() != ')') {
					postFix.add(stack.removeLast())
				}
				if (stack.isNotEmpty()) {
					stack.removeLast()
				}
			}
		}
		while(stack.isNotEmpty()) {
			postFix.add(stack.removeLast())
		}
		return postFix.asReversed()
	}
	
	fun postFixToTree(postFix: MutableList<Char>): Node {
		val stack = mutableListOf<Node>()
		//println(postFix.joinToString(""))
		while(postFix.isNotEmpty()) {
			val token = postFix.removeLast()
			if (isOperand(token)) {
				stack.add(Node(token))
			} else if (isOperator(token)) {
				val r = stack.removeLast()
				val l = stack.removeLast()
				stack.add(Node(token, l, r))
			}
		}
		return stack.removeLast()
	}

	fun expTree(s: String): Node {
		val r = postFixToTree(toPostFix(s))
		return r
	}
}
fun inOrderTraversal(node: Node?, sb: StringBuilder = StringBuilder() ): StringBuilder {
	if (node == null) {
		return sb
	}
	inOrderTraversal(node.left, sb)
	sb.append(node.`val`)
	inOrderTraversal(node.right, sb)
	return sb
}
=======


>>>>>>> Stashed changes

fun main(args: Array<String>) {
 	println(inOrderTraversal(Solution().expTree("3*4-2*5")))
 	println(inOrderTraversal(Solution().expTree("2-3/(5*2)+1")))
 	println(inOrderTraversal(Solution().expTree("1+2+3+4+5")))
}
