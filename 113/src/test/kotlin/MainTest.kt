import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val root = TreeNode(5).apply {
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
		val expected = listOf(listOf(5,4,11,2),listOf(5,8,4,5))
		Assert.assertEquals(expected, Solution().pathSum(root, targetSum))
	}

	@Test
	fun `Example 2`() {
		val root = TreeNode(1).apply {
			left = TreeNode(2)
			right = TreeNode(3)
		}
		val targetSum = 5
		val expected = listOf<List<Int>>()
		Assert.assertEquals(expected, Solution().pathSum(root, targetSum))
	}
}

