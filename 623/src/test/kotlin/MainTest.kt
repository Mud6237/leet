import org.junit.Test
import org.junit.Assert

class MainTest {
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
		val expected = listOf(4,1,1,2,null,null,6,3,1,5)
		Assert.assertEquals(expected, Solution().addOneRow(root, v, depth))
	}

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
		val expected = listOf(4,2,null,1,1,3,null,null,1)
		Assert.assertEquals(expected, Solution().addOneRow(root, v, depth))
	}
}

