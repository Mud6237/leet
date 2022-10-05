import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		var root = TreeNode(3)
		val pNode = TreeNode(5)
		val qNode = TreeNode(1)
		val tree = root.apply {
			left = pNode.apply {
				left = TreeNode(6)
				right = TreeNode(2).apply {
					left = TreeNode(7)
					right = TreeNode(4)
				}
			}
			right = qNode.apply {
				left = TreeNode(0)
				right = TreeNode(8)
			}
		}
		val expected = root
		Assert.assertEquals(expected, Solution().lowestCommonAncestor(tree, pNode, qNode))
	}

	@Test
	fun `Example 2`() {
		var root = TreeNode(3)
		val pNode = TreeNode(5)
		val qNode = TreeNode(4)
		val tree = root.apply {
			left = pNode.apply {
				left = TreeNode(6)
				right = TreeNode(2).apply {
					left = TreeNode(7)
					right = qNode
				}
			}
			right = TreeNode(1).apply {
				left = TreeNode(0)
				right = TreeNode(8)
			}
		}
		val expected = pNode
		Assert.assertEquals(expected, Solution().lowestCommonAncestor(tree, pNode, qNode))
	}

	@Test
	fun `Example 3`() {
		var root = TreeNode(1)
		val tree = root.apply {
			left = TreeNode(2)
		}
		val pNode = tree
		val qNode = tree.left
		val expected = root
		Assert.assertEquals(expected, Solution().lowestCommonAncestor(tree, pNode, qNode))
	}

	@Test
	fun `Example 4`() {
		var root = TreeNode(1)
		val tree = root
		val pNode = tree
		val qNode = tree
		val expected = root
		Assert.assertEquals(expected, Solution().lowestCommonAncestor(tree, pNode, qNode))
	}

	@Test
	fun `Example 5`() {
		var root = TreeNode(3)
		val pNode = TreeNode(2)
		val qNode = TreeNode(0)
		val tree = root.apply {
			left = TreeNode(5).apply {
				left = TreeNode(6)
				right = pNode.apply {
					left = TreeNode(7)
					right = TreeNode(4)
				}
			}
			right = TreeNode(1).apply {
				left = qNode
				right = TreeNode(8)
			}
		}
		val expected = root
		Assert.assertEquals(expected, Solution().lowestCommonAncestor(tree, qNode, pNode))
	}

	@Test
	fun `Example 6`() {
		var root = TreeNode(3)
		val pNode = TreeNode(6)
		val qNode = TreeNode(7)
		val tree = root.apply {
			left = TreeNode(5).apply {
				left = pNode
				right = TreeNode(2).apply {
					left = qNode
					right = TreeNode(4)
				}
			}
			right = TreeNode(1).apply {
				left = TreeNode(0)
				right = TreeNode(8)
			}
		}
		val expected = root.left
		Assert.assertEquals(expected, Solution().lowestCommonAncestor(tree, qNode, pNode))
	}
}

