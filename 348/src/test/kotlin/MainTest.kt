import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val ttt = TicTacToe(3)
		Assert.assertEquals(0, ttt.move(0, 0, 1))
		Assert.assertEquals(0,ttt.move(0, 2, 2))
		Assert.assertEquals(0,ttt.move(2, 2, 1))
		Assert.assertEquals(0,ttt.move(1, 1, 2))
		Assert.assertEquals(0,ttt.move(2, 0, 1))
		Assert.assertEquals(0,ttt.move(1, 0, 2))
		Assert.assertEquals(1,ttt.move(2, 1, 1))
	}

	@Test
	fun `Example 2`() {
		val ttt = TicTacToe(3)
		Assert.assertEquals(0, ttt.move(0, 0, 1))
		Assert.assertEquals(0, ttt.move(0, 1, 2))
		Assert.assertEquals(0, ttt.move(0, 2, 1))
		Assert.assertEquals(0, ttt.move(1, 0, 2))
		Assert.assertEquals(0, ttt.move(1, 1, 1))
		Assert.assertEquals(0, ttt.move(1, 2, 2))
		Assert.assertEquals(1, ttt.move(2, 0, 1))
		
	}

	@Test
	fun `Example 3`() {
		val ttt = TicTacToe(3)
		Assert.assertEquals(0, ttt.move(0, 0, 2))
		Assert.assertEquals(0, ttt.move(1, 1, 2))
		Assert.assertEquals(2, ttt.move(2, 2, 2))
	}

	@Test
	fun `Example 4`() {
		val ttt = TicTacToe(3)
		Assert.assertEquals(0, ttt.move(0, 1, 2))
		Assert.assertEquals(0, ttt.move(2, 1, 2))
		Assert.assertEquals(2, ttt.move(1, 1, 2))
	}

	@Test
	fun `Example 5`() {
		val ttt = TicTacToe(3)
		Assert.assertEquals(0, ttt.move(2, 1, 2))
		Assert.assertEquals(0, ttt.move(1, 1, 2))
		Assert.assertEquals(2, ttt.move(0, 1, 2))
	}

	@Test
	fun `Example 6`() {
		val ttt = TicTacToe(3)
		Assert.assertEquals(0, ttt.move(2, 0, 2))
		Assert.assertEquals(0, ttt.move(1, 1, 2))
		Assert.assertEquals(2, ttt.move(0, 2, 2))
	}

	@Test
	fun `Example 7`() {
		val ttt = TicTacToe(3)
		Assert.assertEquals(0, ttt.move(0, 0, 2))
		Assert.assertEquals(0, ttt.move(1, 1, 2))
		Assert.assertEquals(2, ttt.move(2, 2, 2))
	}

	@Test
	fun `Example 8`() {
		val ttt = TicTacToe(3)
		Assert.assertEquals(0, ttt.move(1, 2, 2))
		Assert.assertEquals(0, ttt.move(1, 1, 2))
		Assert.assertEquals(2, ttt.move(1, 0, 2))
	}

	@Test
	fun `Example 9`() {
		val ttt = TicTacToe(4)
		Assert.assertEquals(0, ttt.move(1, 0, 2))
		Assert.assertEquals(0, ttt.move(1, 2, 2))
		Assert.assertEquals(0, ttt.move(1, 1, 2))
		Assert.assertEquals(2, ttt.move(1, 3, 2))
	}
}

