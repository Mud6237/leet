import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`() {
		val l1 = ListNode(7).apply{
			next= ListNode(2).apply{
				next= ListNode(4).apply{
					next= ListNode(3)
				}
			}
		}
		val l2 = ListNode(5).apply{
			next = ListNode(6).apply{
				next = ListNode(4)
			}
		}
		Solution().addTwoNumbers(l1, l2)
	}
}

