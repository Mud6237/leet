import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val snakeGame = SnakeGame(3, 2, arrayOf(intArrayOf(1, 2), intArrayOf(0, 1)));
		Assert.assertEquals(0,snakeGame.move("R"))
		Assert.assertEquals(0,snakeGame.move("D"))
		Assert.assertEquals(1,snakeGame.move("R"))
		Assert.assertEquals(1,snakeGame.move("U"))
		Assert.assertEquals(2,snakeGame.move("L"))
		Assert.assertEquals(-1,snakeGame.move("U"))
	}

	@Test
	fun `Example 437`() {
		val snakeGame = SnakeGame(3, 3, arrayOf(
			intArrayOf(2,0),
			intArrayOf(0,0),
			intArrayOf(0,2),
			intArrayOf(2,2))
		)
		Assert.assertEquals(0,snakeGame.move("D"))
		Assert.assertEquals(1,snakeGame.move("D"))
		Assert.assertEquals(1,snakeGame.move("R"))
		Assert.assertEquals(1,snakeGame.move("U"))
		Assert.assertEquals(1,snakeGame.move("U"))
		Assert.assertEquals(2,snakeGame.move("L"))
		Assert.assertEquals(2,snakeGame.move("D"))
		Assert.assertEquals(2,snakeGame.move("R"))
		Assert.assertEquals(2,snakeGame.move("R"))
		Assert.assertEquals(3,snakeGame.move("U"))
		Assert.assertEquals(3,snakeGame.move("L"))
		Assert.assertEquals(3,snakeGame.move("D"))
	}

	@Test
	fun `Example 81`() {
		val snakeGame = SnakeGame(3, 3, arrayOf(
			intArrayOf(0,2),
			intArrayOf(2,2),
			intArrayOf(1,2),
			intArrayOf(0,1))
		);
		Assert.assertEquals(0, snakeGame.move("R"))
		Assert.assertEquals(1, snakeGame.move("R"))
		Assert.assertEquals(1, snakeGame.move("D"))
		Assert.assertEquals(1, snakeGame.move("L"))
		Assert.assertEquals(1, snakeGame.move("D"))
		Assert.assertEquals(2, snakeGame.move("R"))
		Assert.assertEquals(3, snakeGame.move("U"))
		Assert.assertEquals(3, snakeGame.move("U"))
		Assert.assertEquals(4, snakeGame.move("L"))
		Assert.assertEquals(4, snakeGame.move("D"))
	}
	@Test
	fun `Example 85`() {
		val snakeGame = SnakeGame(13,60, arrayOf(
			intArrayOf(3,1),intArrayOf(13,0))
		)
		Assert.assertEquals(0,snakeGame.move("D"))
		Assert.assertEquals(0,snakeGame.move("D"))
		Assert.assertEquals(0,snakeGame.move("R"))
		Assert.assertEquals(1,snakeGame.move("D"))
		Assert.assertEquals(1,snakeGame.move("D"))
		Assert.assertEquals(1,snakeGame.move("D"))
		Assert.assertEquals(1,snakeGame.move("D"))
		Assert.assertEquals(1,snakeGame.move("D"))
		Assert.assertEquals(1,snakeGame.move("R"))
		Assert.assertEquals(1,snakeGame.move("R"))
		Assert.assertEquals(1,snakeGame.move("R"))
		Assert.assertEquals(1,snakeGame.move("R"))
		Assert.assertEquals(1,snakeGame.move("U"))
		Assert.assertEquals(1,snakeGame.move("R"))
		Assert.assertEquals(1,snakeGame.move("U"))
		Assert.assertEquals(1,snakeGame.move("R"))
		Assert.assertEquals(1,snakeGame.move("R"))
		Assert.assertEquals(1,snakeGame.move("U"))
		Assert.assertEquals(1,snakeGame.move("U"))
		Assert.assertEquals(1,snakeGame.move("L"))
		Assert.assertEquals(1,snakeGame.move("L"))
		Assert.assertEquals(1,snakeGame.move("D"))
		Assert.assertEquals(1,snakeGame.move("L"))
		Assert.assertEquals(1,snakeGame.move("L"))
		Assert.assertEquals(1,snakeGame.move("U"))
		Assert.assertEquals(1,snakeGame.move("L"))
		Assert.assertEquals(1,snakeGame.move("U"))
		Assert.assertEquals(1,snakeGame.move("R"))
		Assert.assertEquals(1,snakeGame.move("U"))
		Assert.assertEquals(1,snakeGame.move("R"))
		Assert.assertEquals(1,snakeGame.move("U"))
		Assert.assertEquals(1,snakeGame.move("R"))
	}
}

