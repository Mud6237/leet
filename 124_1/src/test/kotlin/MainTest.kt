import org.junit.Test
import org.junit.Assert
import org.junit.Ignore

class MainTest {
	@Test
	fun `Example 1`() {
		val root = TreeNode(1).apply {
			left = TreeNode(2)
			right = TreeNode(3)
		}		
		val expected = 6
		Assert.assertEquals(expected, Solution().maxPathSum(root))
	}

	@Test
	fun `Example 2`() {
		val root = TreeNode(-10).apply {
			left = TreeNode(9)
			right = TreeNode(20).apply {
				left = TreeNode(15)
				right = TreeNode(7)
			}
		}		
		val expected = 42
		Assert.assertEquals(expected, Solution().maxPathSum(root))
	}

	@Test
	fun `TestCase 66`() {
		val root = TreeNode(-3)
		val expected = -3
		Assert.assertEquals(expected, Solution().maxPathSum(root))
	}

	@Test
	fun `TestCase 70`() {
		val root = TreeNode(2).apply {
			left = TreeNode(-1)
		}
		val expected = 2
		Assert.assertEquals(expected, Solution().maxPathSum(root))
	}
}

