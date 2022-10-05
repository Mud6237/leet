import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val tree = TreeNode(7).apply {
			left = TreeNode(3)
			right = TreeNode(15).apply {
				left = TreeNode(9)
				right = TreeNode(20)
			}
		}
		val bSTIterator = BSTIterator(tree)
		Assert.assertEquals(3, bSTIterator.next())
		Assert.assertEquals(7, bSTIterator.next())
		Assert.assertEquals(true, bSTIterator.hasNext())
		Assert.assertEquals(9, bSTIterator.next())
		Assert.assertEquals(true, bSTIterator.hasNext())
		Assert.assertEquals(15, bSTIterator.next())
		Assert.assertEquals(true, bSTIterator.hasNext())
		Assert.assertEquals(20, bSTIterator.next())
		Assert.assertEquals(false, bSTIterator.hasNext())
	}
}

