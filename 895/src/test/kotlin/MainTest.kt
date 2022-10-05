import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val freqStack = FreqStack()
		freqStack.push(5); // The stack is [5]
		freqStack.push(7); // The stack is [5,7]
		freqStack.push(5); // The stack is [5,7,5]
		freqStack.push(7); // The stack is [5,7,5,7]
		freqStack.push(4); // The stack is [5,7,5,7,4]
		freqStack.push(5); // The stack is [5,7,5,7,4,5]
		Assert.assertEquals(5, freqStack.pop())
		Assert.assertEquals(7, freqStack.pop())
		Assert.assertEquals(5, freqStack.pop())
		Assert.assertEquals(4, freqStack.pop())
		Assert.assertEquals(7, freqStack.pop())
		Assert.assertEquals(5, freqStack.pop())
	}
}

