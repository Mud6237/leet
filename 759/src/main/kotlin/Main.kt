// https://leetcode.com/problemset/all?search=759
// https://leetcode.com/problems/employee-free-time/discussions

import java.util.PriorityQueue

// Definition for an Interval.
class Interval {
    var start:Int = 0
    var end:Int = 0
    constructor(_start:Int, _end:Int) {
        start = _start
        end = _end
    }
    override fun toString(): String {
        val s = if (start == -1) "-Inf" else "$start"
        val e = if (end == Int.MAX_VALUE) "Inf" else "$end"
        return "[$s, $e]"
    }
}

class Solution {
    fun employeeFreeTime(schedule: ArrayList<ArrayList<Interval>>): ArrayList<Interval> {
        val result = ArrayList<Interval>()
        /*val freeIntervals = ArrayList<ArrayList<Interval>>()
        for(employeeSchedule in schedule) {
            val emplyeeIntervalList = arrayListOf(Interval(-1, employeeSchedule.first().start))
            for(i in 1..employeeSchedule.lastIndex) {
                val currentInteval = employeeSchedule[i]
                val lastInterval = employeeSchedule[i-1]
                if (currentInteval.start - lastInterval.end > 0) {
                    emplyeeIntervalList.add(Interval(lastInterval.end, currentInteval.start))
                }
            }
            emplyeeIntervalList.add(Interval(employeeSchedule.last().end, Int.MAX_VALUE))
            freeIntervals.add(emplyeeIntervalList)
        } */
        val employeeMinHeaps = Array<PriorityQueue<Interval>>(schedule.size, {
            PriorityQueue<Interval>(){i1, i2 -> i1.start - i2.start }
        })
        for(i in 0..schedule.lastIndex) {
            val employeeSchedule = schedule[i]
            employeeMinHeaps[i].add(Interval(-1, employeeSchedule.first().start))
            for(j in 1..employeeSchedule.lastIndex) {
                val currentInteval = employeeSchedule[j]
                val lastInterval = employeeSchedule[j-1]
                if (currentInteval.start - lastInterval.end > 0) {
                    employeeMinHeaps[i].add(Interval(lastInterval.end, currentInteval.start))
                }
            }
            employeeMinHeaps[i].add(Interval(employeeSchedule.last().end, Int.MAX_VALUE))
        }
        var done = false
        while (!done) {
            var maxStart = -1
            var minEnd = Int.MAX_VALUE
            for(e in employeeMinHeaps)  {
                if (e.isEmpty()) {
                    done = true
                    break
                }
                val minInterval = e.peek()
                maxStart = Math.max(maxStart, minInterval.start)
                minEnd = Math.min(minEnd, minInterval.end)
            }
            //println("Max Start =$maxStart, Min End=$minEnd")
            if (minEnd > maxStart && minEnd != Int.MAX_VALUE && maxStart != -1) {
                result.add(Interval(maxStart, minEnd))
            }
            for(e in employeeMinHeaps) {
                val interval = e.poll()
                if (interval == null) {
                    done = true
                    break
                }
                if (interval.end > minEnd) {
                    e.add(Interval(minEnd, interval.end))
                } else {
                    //println("removing $interval ")
                }
            }
        }
        return result
    }
}

fun main(args: Array<String>) {
}
