import org.junit.Test
import org.junit.Assert


class MainTest {
	@Test
	fun `Example 1`() {
		val list = ListNode(1).apply {
			next = ListNode(2).apply{
				next = ListNode(3).apply {
					next = ListNode(4)
				}
			}
		}
		val expected = listOf(1, 4, 2, 3)
		Solution().reorderList(list)
		val result = Solution.toArrayList(list)
		Assert.assertEquals(expected, result)
	}

	@Test
	fun `Example 2`() {
		val list = ListNode(1).apply {
			next = ListNode(2).apply{
				next = ListNode(3).apply {
					next = ListNode(4).apply {
						next = ListNode(5).apply {
						}
					}
				}
			}
		}
		val expected = listOf(1, 5, 2, 4, 3)
		Solution().reorderList(list)
		val result = Solution.toArrayList(list)
		
		Assert.assertEquals(expected, result)
	}

	@Test
	fun `Example 3`() {
		val list = ListNode(1)
		val expected = listOf(1)
		Solution().reorderList(list)
		val result = Solution.toArrayList(list)
		
		Assert.assertEquals(expected, result)
	}

	@Test
	fun `Example 4`() {
		val list = ListNode(1).apply {
			next = ListNode(2)
		}
		val expected = listOf(1, 2)
		Solution().reorderList(list)
		val result = Solution.toArrayList(list)
		Assert.assertEquals(expected, result)
	}

	@Test
	fun `Example 5`() {
		val list = ListNode(1).apply {
			next = ListNode(2).apply {
				next = ListNode(3)
			}
		}
		val expected = listOf(1, 3, 2)
		Solution().reorderList(list)
		val result = Solution.toArrayList(list)
		Assert.assertEquals(expected, result)
	}
}

