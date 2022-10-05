class Solution {
	fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
		if (gas.sum() < cost.sum()) {
			return -1
		}
		var k = 0
		var g = 0
		for(i in 0 until gas.size) {
			g += gas[i]
			if (cost[i] <= g) {
				g -= cost[i]
			} else {
				g = 0
				k = i + 1
			}
		}
		return k
	}
}