import org.junit.Test
import org.junit.Assert

class MainTest {
	@Test
	fun `Example 1`(){
		var undergroundSystem = UndergroundSystem()
		undergroundSystem.checkIn(45, "Leyton", 3)
		undergroundSystem.checkIn(32, "Paradise", 8)
		undergroundSystem.checkIn(27, "Leyton", 10)
		undergroundSystem.checkOut(45, "Waterloo", 15) 
		undergroundSystem.checkOut(27, "Waterloo", 20) 
		undergroundSystem.checkOut(32, "Cambridge", 22)
		Assert.assertEquals(14.00000,undergroundSystem.getAverageTime("Paradise", "Cambridge"),0.00005)
		Assert.assertEquals(11.00000,undergroundSystem.getAverageTime("Leyton", "Waterloo"),0.00005)
		undergroundSystem.checkIn(10, "Leyton", 24)
		Assert.assertEquals(11.00000, undergroundSystem.getAverageTime("Leyton", "Waterloo"), 0.00005)
		undergroundSystem.checkOut(10, "Waterloo", 38)
		Assert.assertEquals(12.00000, undergroundSystem.getAverageTime("Leyton", "Waterloo"), 0.00005)		
	}

	@Test
	fun `Example 2`(){
		val undergroundSystem = UndergroundSystem()
		undergroundSystem.checkIn(10, "Leyton", 3)
		undergroundSystem.checkOut(10, "Paradise", 8)
		Assert.assertEquals(5.00000,undergroundSystem.getAverageTime("Leyton", "Paradise"), 0.00005)
		undergroundSystem.checkIn(5, "Leyton", 10)
		undergroundSystem.checkOut(5, "Paradise", 16)
		Assert.assertEquals(5.50000,undergroundSystem.getAverageTime("Leyton", "Paradise"), 0.00005)
		undergroundSystem.checkIn(2, "Leyton", 21)
		undergroundSystem.checkOut(2, "Paradise", 30)
		Assert.assertEquals(6.66667,undergroundSystem.getAverageTime("Leyton", "Paradise"), 0.00005)
	}
}

