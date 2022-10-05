//https://leetcode.com/problems/design-underground-system/
class UndergroundSystem() {
	private val citiesStatMap = hashMapOf<String, HashMap<String, Pair<Int, Int>>>()
	private val customerMap = hashMapOf<Int, Triple<Int, String, Int>>()
	fun checkIn(id: Int, stationName: String, t: Int) {
		if (!customerMap.contains(id)) {
			customerMap[id] = Triple(id, stationName, t)
		}
	}

	fun checkOut(id: Int, stationName: String, t: Int) {
		val checkInTriple = customerMap.get(id) ?: return
		val cityStatMap = citiesStatMap.getOrPut(checkInTriple.second, { hashMapOf()})
		val oldStat = cityStatMap.getOrPut(stationName, { (0 to 0) })
		val newStat = (oldStat.first + t - checkInTriple.third) to (oldStat.second + 1)
		cityStatMap[stationName] = newStat
		citiesStatMap[checkInTriple.second] = cityStatMap
		customerMap.remove(id)
	}

	fun getAverageTime(startStation: String, endStation: String): Double {
		val cityStatMap = citiesStatMap[startStation] ?: return 0.0
		val stat = cityStatMap[endStation] ?: return 0.0
		return stat.first.toDouble() / stat.second
	}
}