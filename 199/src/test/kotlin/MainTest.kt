import org.junit.Test
import org.junit.Ignore
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val tree = TreeNode(1).apply {
			left = TreeNode(2).apply {
				right = TreeNode(5)
			}
			right = TreeNode(3).apply {
				right = TreeNode(4)
			}
		}
		val expected = listOf(1, 3, 4)
		Assert.assertEquals(expected, Solution().rightSideView(tree))
	}
	@Test
	fun `Example 2`() {
		val tree = TreeNode(1).apply {
			right = TreeNode(3).apply {
			}
		}
		val expected = listOf(1, 3)
		Assert.assertEquals(expected, Solution().rightSideView(tree))
	}

	@Test
	fun `Example 157`() {
		val tree = TreeNode(1).apply {
			left = TreeNode(2).apply {
				left = TreeNode(4)
			}
			right = TreeNode(3)
		}
		val expected = listOf(1, 3, 4)
		Assert.assertEquals(expected, Solution().rightSideView(tree))
	}
  @Test
	fun `Example 3`() {
		val tree = TreeNode(1).apply {
			left = TreeNode(2).apply {
				left = TreeNode(4).apply {
					left = TreeNode(1).apply {
						left = TreeNode(2)
					}
				}
				right = TreeNode(5)
			}
			right = TreeNode(3).apply {
				right = TreeNode(7)
			}
		}
		val expected = listOf(1,3,7,1,2)
		Assert.assertEquals(expected, Solution().rightSideView(tree))
	}
  @Test
	fun `Example 4`() {
		val tree = TreeNode(1)
		val expected = listOf(1)
		Assert.assertEquals(expected, Solution().rightSideView(tree))
	}
  @Test
	fun `Example 5`() {
		val expected = listOf<Int>()
		Assert.assertEquals(expected, Solution().rightSideView(null))
	}

}

