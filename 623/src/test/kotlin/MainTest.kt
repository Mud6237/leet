import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {

	fun levelOrder(n: TreeNode?): List<Int?> {
		val r = mutableListOf<Int?>()
		var q = listOf<TreeNode?>(n)
		while(q.isNotEmpty()) {
			val nq = mutableListOf<TreeNode?>()
			var index = -1
			for(node in q) {
				r.add(node?.`val`)
				nq.add(node?.left)
				nq.add(node?.right)
				if (node?.right != null) {
					index += 2
				} else if (node?.left != null) {
					index += 1
				}
			}
			if (index >= 0) {
				q = nq
			} else {
				q = emptyList()
			}
		}
		var k = r.lastIndex
		while(k >= 0 && r[k] == null) {
			k -= 1
		}
		return r.slice(0..k)
	}

	@Test
	fun `Example 1`() {
		val root = TreeNode(4).apply {
			left = TreeNode(2).apply {
				left = TreeNode(3)
				right = TreeNode(1)
			}
			right = TreeNode(6).apply {
				left = TreeNode(5)
			}
		}
		val v = 1
		val depth = 2
		val expected = listOf<Int?>(4,1,1,2,null,null,6,3,1,5)
		val actual = levelOrder(Solution().addOneRow(root, v, depth))
		Assert.assertEquals(expected, actual)
	}

	@Ignore
	@Test
	fun `Example 2`() {
		val root = TreeNode(4).apply {
			left = TreeNode(2).apply {
				left = TreeNode(3)
				right = TreeNode(1)
			}
		}
		val v = 1
		val depth = 2
		val expected = listOf<Int?>(4,2,null,1,1,3,null,null,1)
		val actual = levelOrder(Solution().addOneRow(root, v, depth))
		Assert.assertEquals(expected, actual)
	}
}

