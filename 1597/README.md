A **[binary expression tree](https://en.wikipedia.org/wiki/Binary_expression_tree)** is a kind of binary tree used to represent arithmetic expressions. Each node of a binary expression tree has either zero or two children. Leaf nodes (nodes with 0 children) correspond to operands (numbers), and internal nodes (nodes with 2 children) correspond to the operators `'+'` (addition), `'-'` (subtraction), `'*'` (multiplication), and `'/'` (division).

For each internal node with operator `o`, the [**infix expression**](https://en.wikipedia.org/wiki/Infix_notation) that it represents is `(A o B)`, where `A` is the expression the left subtree represents and `B` is the expression the right subtree represents.

You are given a string `s`, an **infix expression** containing operands, the operators described above, and parentheses `'('` and `')'`.

Return _any valid **binary expression tree**, which its **[in-order traversal](https://en.wikipedia.org/wiki/Tree_traversal#In-order_(LNR))** reproduces_ `s` after omitting the parenthesis from it (see examples below)_._

**Please note that order of operations applies in** `s`**.** That is, expressions in parentheses are evaluated first, and multiplication and division happen before addition and subtraction.

Operands must also appear in the **same order** in both `s` and the in-order traversal of the tree.

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/02/ex1-4.png)

**Input:** s = "3\*4-2\*5"
**Output:** \[-,\*,\*,3,4,2,5\]
**Explanation:** The tree above is the only valid tree whose inorder traversal produces s.

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/10/02/ex1-2.png)

**Input:** s = "2-3/(5\*2)+1"
**Output:** \[+,-,1,2,/,null,null,null,null,3,\*,null,null,5,2\]
**Explanation:** The inorder traversal of the tree above is 2-3/5\*2+1 which is the same as s without the parenthesis. The tree also produces the correct result and its operands are in the same order as they appear in s.
The tree below is also a valid binary expression tree with the same inorder traversal as s, but it not a valid answer because it does not evaluate to the same value.
![](https://assets.leetcode.com/uploads/2020/10/02/ex1-1.png)
The third tree below is also not valid. Although it produces the same result and is equivalent to the above trees, its inorder traversal does not produce s and its operands are not in the same order as s.
![](https://assets.leetcode.com/uploads/2020/10/02/ex1-3.png)

**Example 3:**

**Input:** s = "1+2+3+4+5"
**Output:** \[+,+,5,+,4,null,null,+,3,null,null,1,2\]
**Explanation:** The tree \[+,+,5,+,+,null,null,1,2,3,4\] is also one of many other valid trees.

**Constraints:**

*   `1 <= s.length <= 1000`
*   `s` consists of digits and the characters `'+'`, `'-'`, `'*'`, and `'/'`.
*   Operands in `s` are **exactly** 1 digit.
*   It is guaranteed that `s` is a valid expression.