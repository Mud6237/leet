import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val root  = TreeNode(3).apply {
			left = TreeNode(9)
			right = TreeNode(20).apply {
				left = TreeNode(15)
				right = TreeNode(7)
			}
		}
		val expected = listOf(listOf(3), listOf(20, 9), listOf(15, 7))
		Assert.assertEquals(expected, Solution().zigzagLevelOrder(root))
	}

	@Test
	fun `Example 2`() {
		val root  = TreeNode(1).apply {
			left = TreeNode(2).apply {
				left = TreeNode(4)
			}
			right = TreeNode(3).apply {
				right = TreeNode(5)
			}
		}
		val expected = listOf(listOf(1), listOf(3, 2), listOf(4, 5))
		Assert.assertEquals(expected, Solution().zigzagLevelOrder(root))
	}

	@Test
	fun `Example 3`() {
		val root  = TreeNode(0).apply {
			left = TreeNode(2).apply {
				left = TreeNode(1).apply {
					left = TreeNode(5)
					right = TreeNode(1)
				}
			}
			right = TreeNode(4).apply {
				left = TreeNode(3).apply {
					left = TreeNode(6)
				}
				right = TreeNode(-1).apply {
					right = TreeNode(8)
				}
			}
		}
		val expected = listOf(listOf(0), listOf(4, 2), listOf(1,3,-1), listOf(8,6,1,5))
		Assert.assertEquals(expected, Solution().zigzagLevelOrder(root))
	}
}

