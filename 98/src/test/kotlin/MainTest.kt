import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val root = TreeNode(2).apply {
			left = TreeNode(1)
			right = TreeNode(3)
		}
		val expected = true
		Assert.assertEquals(expected, Solution().isValidBST(root))
	}

	@Test
	fun `Example 2`() {
		val root = TreeNode(5).apply {
			left = TreeNode(1)
			right = TreeNode(4).apply {
				left = TreeNode(3)
				right = TreeNode(6)
			}
		}
		val expected = false
		Assert.assertEquals(expected, Solution().isValidBST(root))
	}

	@Test
	fun `Example 68`() {
		val root = TreeNode(2).apply {
			left = TreeNode(2)
			right = TreeNode(2)
		}
		val expected = false
		Assert.assertEquals(expected, Solution().isValidBST(root))
	}
}

