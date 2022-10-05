import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val head = Node(7).also { node1 ->
			node1.next = Node(13).also { node2 ->
				node2.next = Node(11).also { node3 ->
					node3.next = Node(10).also { node4 ->
						node4.next = Node(1).also { node5 ->
							node2.random = node1
							node3.random = node5
							node4.random = node3
							node5.random = node1
						}
					}	
				}		
			}	
		}
		val expected = listOf(listOf<Int?>(7,null),listOf<Int?>(13,0),listOf<Int?>(11,4),listOf<Int?>(10,2),listOf<Int?>(1,0))
		val outputHead = Solution().copyRandomList(head)
		val actual = Solution.toArrayList(outputHead)
		Assert.assertEquals(expected, actual)
	}
	
	@Test
	fun `Example 2`() {
		val head = Node(1).also { node1 ->
			node1.next = Node(2).also { node2 ->
				node1.random = node2
				node2.random = node2
			}	
		}
		val expected = listOf(listOf<Int?>(1,1),listOf<Int?>(2,1))
		val outputHead = Solution().copyRandomList(head)
		val actual = Solution.toArrayList(outputHead)
		Assert.assertEquals(expected, actual)
	}

	@Test
	fun `Example 3`() {
		val head = Node(3).also { node1 ->
			node1.next = Node(3).also { node2 ->
				node2.next = Node(3).also { _ ->
					node2.random = node1
				}	
			}	
		}
		val expected = listOf(listOf<Int?>(3,null),listOf<Int?>(3,0), listOf<Int?>(3, null))
		val outputHead = Solution().copyRandomList(head)
		val actual = Solution.toArrayList(outputHead)
		Assert.assertEquals(expected, actual)
	}
}

