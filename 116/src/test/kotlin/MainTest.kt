import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val tree = Node(1).apply {
			left = Node(2).apply{
				left = Node(4)
				right = Node(5)
			}
			right = Node(3).apply {
				left = Node(6)
				right = Node(7)
			}
		}
		Solution().connect(tree)
		val actual = Solution.levelOrder(tree)
		val expected = listOf("1","#","2","3","#","4","5","6","7","#")
		Assert.assertEquals(expected, actual)
	}
	@Test
	fun `Example 2`() {
		Solution().connect(null)
		val actual = Solution.levelOrder(null)
		val expected = listOf<String>()
		Assert.assertEquals(expected, actual)
	}

	@Test
	fun `Example 3`() {
		val tree = Node(1).apply {
			left = Node(2)
			right = Node(3)
		}
		Solution().connect(tree)
		val actual = Solution.levelOrder(tree)
		val expected = listOf("1" , "#", "2", "3", "#")
		Assert.assertEquals(expected, actual)
	}
	@Test
	fun `Example 4`() {
		val tree = Node(1).apply {
			left = Node(2)
		}
		Solution().connect(tree)
		val actual = Solution.levelOrder(tree)
		val expected = listOf("1" , "#", "2", "#")
		Assert.assertEquals(expected, actual)
	}
	@Test
	fun `Example 5`() {
		val tree = Node(1).apply {
			left = Node(2).apply{
				left = Node(4).apply {
					left = Node(8)
					right = Node(9)
				}
				right = Node(5).apply {
					left = Node(10)
					right = Node(11)
				}
			}
			right = Node(3).apply {
				left = Node(6).apply{
					left = Node(12)
					right = Node(13)
				}
				right = Node(7).apply{
					left = Node(14)
					right = Node(15)
				}
			}
		}
		Solution().connect(tree)
		val actual = Solution.levelOrder(tree)
		val expected = listOf("1", "#", "2", "3", "#", "4", "5", "6", "7", "#", "8", "9", "10", "11", "12", "13", "14", "15", "#")
		Assert.assertEquals(expected, actual)
	}
}