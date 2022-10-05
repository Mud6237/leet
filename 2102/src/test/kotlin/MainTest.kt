import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val tracker = SORTracker()
		tracker.add("bradford", 2)
		tracker.add("branford", 3)
		Assert.assertEquals("branford", tracker.get())
		tracker.add("alps", 2)
		Assert.assertEquals("alps", tracker.get())
		tracker.add("orland", 2)
		Assert.assertEquals("bradford", tracker.get())
		tracker.add("alpine", 2)
		Assert.assertEquals("bradford", tracker.get())
		Assert.assertEquals("orland", tracker.get())
	}
}

