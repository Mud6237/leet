import org.junit.Test
import org.junit.Ignore
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val root = Node(1).apply {
			left = Node(2).apply {
				left = Node(4)
				right = Node(5)
			}
			right = Node(3).apply {
				right = Node(7)
			}
		}
		val expected = listOf("1","#","2","3","#","4","5","7","#")
		Solution().connect(root)
		val actual = Solution.levelOrder(root)
		Assert.assertEquals(expected, actual)
	}

	@Test
	fun `Example 2`() {
		val root = Node(1).apply {
			left = Node(2).apply {
				left = Node(4)
				right = Node(5)
			}
			right = Node(3).apply {
				left = Node(6)
				right = Node(7)
			}
		}
		val expected = listOf("1","#","2","3","#","4","5","6","7","#")
		Solution().connect(root)
		val actual = Solution.levelOrder(root)
		Assert.assertEquals(expected, actual)
	}

	@Test
	fun `Example 3`() {
		val root = Node(1).apply {
			left = Node(2).apply {
				left = Node(4).apply {
					left = Node(6)
				}
			}
			right = Node(3).apply {
				right = Node(5).apply {
					right = Node(7)
				}
			}
		}
		val expected = listOf("1","#","2","3","#","4","5","#","6","7","#")
		Solution().connect(root)
		val actual = Solution.levelOrder(root)
		Assert.assertEquals(expected, actual)
	}

	@Test 
	fun `Example 34`() {
		val root = Node(1).apply {
			left = Node(2).apply {
				left = Node(4).apply {
					left = Node(7)	
				}
				right = Node(5)
			}
			right = Node(3).apply {
				right = Node(6).apply {
					right = Node(8)
				}
			}
		}
		val expected = listOf("1","#","2","3","#","4","5","6","#","7","8","#")
		Solution().connect(root)
		val actual = Solution.levelOrder(root)
		Assert.assertEquals(expected, actual)
	}
	@Test 
	fun `Example 41`() {
		val root = Node(5).apply {
			left = Node(2).apply {
				left = Node(4).apply {
					left = Node(7).apply {
						right = Node(7)
					}
					right = Node(2)
				}
				right = Node(-4).apply {
					right = Node(-9)
				}
			}
			right = Node(-2).apply {
				left = Node(-9).apply {
					left = Node(-9)
				}
				right = Node(2).apply {
					right = Node(3).apply {
						right = Node(3)
					}
				}
			}
		}
		val expected = listOf("5","#", "2", "-2","#", "4", "-4","-9", "2","#", "7", "2", "-9", "-9", "3","#", "7", "3", "#")
		Solution().connect(root)
		val actual = Solution.levelOrder(root)
		Assert.assertEquals(expected, actual)
	}

	@Test 
	fun `Example 5`() {
		val root = Node(5).apply {
			left = Node(2).apply {
				left = Node(4).apply {
					left = Node(7).apply {
						right = Node(7)
					}
					right = Node(2)
				}
			}
			right = Node(-2).apply {
				right = Node(2).apply {
					right = Node(3).apply {
						right = Node(3)
					}
				}
			}
		}
		val expected = listOf("5","#", "2", "-2","#", "4", "2","#", "7", "2", "3","#", "7", "3", "#")
		Solution().connect(root)
		val actual = Solution.levelOrder(root)
		Assert.assertEquals(expected, actual)
	}

	@Test
	fun `Example 39`() {
		val root = Node(2).apply {
			left = Node(1).apply {
				left = Node(0).apply {
					left = Node(2)
				}
				right = Node(7).apply {
					left = Node(1)
					right = Node(0).apply {
						left = Node(7)
					}
				}
			}
			right = Node(3).apply {
				left = Node(9)
				right = Node(1).apply {
					left = Node(8)
					right = Node(8)
				}
			}
		}
		val expected = listOf("2", "#","1", "3", "#","0", "7", "9", "1", "#","2", "1", "0", "8", "8", "#","7", "#")
		Solution().connect(root)
		val actual = Solution.levelOrder(root)
		Assert.assertEquals(expected, actual)
	}
}

