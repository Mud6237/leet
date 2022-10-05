import org.junit.Test
import org.junit.Assert

class MainTest {

    @Test
    fun `assert simple`() {
        var input = intArrayOf(3,3,7,7,10,11,11)
        Assert.assertEquals(Solution().singleNonDuplicate(input), 10)  
        input = intArrayOf( 1,1,2,3,3,4,4,8,8 )
        Assert.assertEquals(Solution().singleNonDuplicate(input), 2)
    }

}