import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val tree = TreeNode(10).apply {
			left = TreeNode(5).apply{
				left = TreeNode(3).apply{
					left = TreeNode(3)
					right = TreeNode(-2)
				}
				right = TreeNode(2).apply {
					right = TreeNode(1)
				}
			}
			right = TreeNode(-3).apply{
				right = TreeNode(11)
			}
		}
		val targetSum = 8
		val expected = 3
		Assert.assertEquals(expected, Solution().pathSum(tree, targetSum))
	}

	@Test
	fun `Example 2`() {
		val tree = TreeNode(5).apply{
			left = TreeNode(4).apply {
				left = TreeNode(11).apply {
					left = TreeNode(7)
					right = TreeNode(2)
				}
			}
			right = TreeNode(8).apply {
				left = TreeNode(13)
				right = TreeNode(4).apply {
					left = TreeNode(5)
					right = TreeNode(1)
				}
			}
		}
		val targetSum = 22
		val expected = 3
		Assert.assertEquals(expected, Solution().pathSum(tree, targetSum))
	}
}

