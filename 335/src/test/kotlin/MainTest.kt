import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 0`() {
		val l1 = Solution.Line(a = Solution.Point(0, 0), b = Solution.Point(0, 2))
		val l2 = Solution.Line(a = Solution.Point(0, 2), b = Solution.Point(-1, 2))
		val l3 = Solution.Line(a = Solution.Point(-1, 2), b = Solution.Point(-1, 1))
		val l4 = Solution.Line(a = Solution.Point(-1, 1), b = Solution.Point(2, 1))
		Assert.assertEquals(false, Solution.intersect(l1, l2))
		Assert.assertEquals(false, Solution.intersect(l2, l3))
		Assert.assertEquals(false, Solution.intersect(l3, l4))
		Assert.assertEquals(true, Solution.intersect(l1, l4))
		Assert.assertEquals(false, Solution.intersect(l2, l4))
		Assert.assertEquals(false, Solution.intersect(l1, l3))
		Assert.assertEquals(false, Solution.intersect(l1, Solution.Line(a = Solution.Point(-1, 1), b = Solution.Point(0, 1))))
		Assert.assertEquals(false, Solution.intersect(Solution.Line(a = Solution.Point(-1, 1), b = Solution.Point(0, 1)), l1))
		Assert.assertEquals(true, Solution.intersect(l1, Solution.Line(a = Solution.Point(-1, 1), b = Solution.Point(1, 1))))
		//Assert.assertEquals(true, Solution.intersect(Solution.Line(a = Solution.Point(-1, 1), b = Solution.Point(1, 1)), l1))
		Assert.assertEquals(true, Solution.intersect(Solution.Line(a = Solution.Point(0, 0), b = Solution.Point(0, 1)), Solution.Line(a = Solution.Point(-1, 0), b = Solution.Point(1, 0))))
	}
	@Test
	fun `Example 1`() {
		val expected = false
		Assert.assertEquals(expected, true)
	}
}

