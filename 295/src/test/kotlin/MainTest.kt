import org.junit.Test
import org.junit.Assert

class MainTest {
    @Test
    fun `Example 1`() {
        val medianFinder = MedianFinder()
        medianFinder.addNum(1)
        medianFinder.addNum(2)
        Assert.assertEquals(medianFinder.findMedian(), 1.5, 0.1)
        medianFinder.addNum(3)
        Assert.assertEquals(medianFinder.findMedian(), 2.0, 0.1)
        
    }
    
}