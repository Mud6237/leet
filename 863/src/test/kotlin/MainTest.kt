import org.junit.Test
import org.junit.Ignore
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val root = TreeNode(3).apply {
			left = TreeNode(5).apply {
				left = TreeNode(6)
				right = TreeNode(2).apply {
					left = TreeNode(7)
					right = TreeNode(4)
				}
			}
			right = TreeNode(1).apply {
				left = TreeNode(0)
				right = TreeNode(8)
			}
		}
		val expected = listOf<Int>(7,4,1)
		Assert.assertEquals(expected, Solution().distanceK(root, root.left, 2))
	}

	@Test
	fun `Example 2`() {
		val root = TreeNode(1)
		val expected = listOf<Int>()
		Assert.assertEquals(expected, Solution().distanceK(root, root, 3))
	}

	@Test
	fun `Example 49`() {
		val target = TreeNode(16)
		val root = TreeNode(0).apply{
			left = TreeNode(1).apply {
				left = TreeNode(3).apply{
					left = TreeNode(4).apply {
						right = TreeNode(7).apply {
							left = TreeNode(10).apply {
								right = target
							}
						}
					}
					right = TreeNode(9).apply {
						left = TreeNode(18)
						right = TreeNode(17).apply{
							left = TreeNode(19)
						}
					}
				}
				right = TreeNode(2).apply {
					left = TreeNode(8).apply {
						left = TreeNode(13)
					}
				}
			}
			right = TreeNode(5).apply {
				left = TreeNode(15)
				right = TreeNode(6).apply {
					left = TreeNode(11).apply {
						left = TreeNode(12)
						right = TreeNode(14)
					}
				}
			}
		}
		val expected = listOf<Int>(18,17,2,0)
		Assert.assertEquals(expected, Solution().distanceK(root, target, 6))
	}

	@Test
	fun `Example 41`() {
		val target = TreeNode(3)
		val root = TreeNode(0).apply {
			left = TreeNode(1).apply {
				right = TreeNode(2).apply {
					right = target.apply {
						right = TreeNode(4)
					}
				}
			}
		}
		val expected = listOf<Int>(3)
		Assert.assertEquals(expected, Solution().distanceK(root, target, 0))
	}

	@Test
	fun `Example 34`() {
		val target = TreeNode(3)
		val root = TreeNode(0).apply {
			left = TreeNode(2)
			right = TreeNode(1).apply {
				left = target
			}
		}
		val expected = listOf<Int>(2)
		Assert.assertEquals(expected, Solution().distanceK(root, target, 3))
	}
}

