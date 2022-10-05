import java.util.PriorityQueue
class Solution {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        intervals.sortBy({it.first()})
        val comparator = compareBy<IntArray>({ it.last() })
        val pq = PriorityQueue<IntArray>(comparator)
        pq.add(intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE))
        for(interval in intervals) {
            val top = pq.peek()
            if (interval.first() >= top.last()) {
                pq.poll()
            }
            pq.add(interval)
        }
        return pq.size - 1
    }
}