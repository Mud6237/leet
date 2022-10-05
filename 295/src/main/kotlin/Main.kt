// https://leetcode.com/problemset/all?search=295
// https://leetcode.com/problems/find-median-from-data-stream/


// https://youtu.be/mNYHDv7SbDI?list=PLEAYkSg4uSQ37A6_NrUnTHEKp6EkAxTMa&t=682
import java.util.PriorityQueue
import java.util.Comparator

class MedianFinder {
	private val hHigh = PriorityQueue<Int>() // MinHeap
	private val hLow = PriorityQueue<Int>(Comparator.reverseOrder()) // MaxHeap
	fun addNum(num: Int) {
		val h = if (hHigh.size > 0) hHigh.peek() else Int.MIN_VALUE
		if (num > h) {
			hHigh.add(num)
		} else {
			hLow.add(num)
		}	
		if (hHigh.size - hLow.size > 1 )  {
			hLow.add(hHigh.poll())
		} else if (hLow.size - hHigh.size > 1) {
			hHigh.add(hLow.poll())
		}
	}

	fun findMedian(): Double {
		println("hLow ${hLow.toList()}")
		println("hHig ${hHigh.toList()}")
		if (hLow.size > hHigh.size) {
			return hLow.peek().toDouble()
		} else if (hHigh.size > hLow.size) {
			return hHigh.peek().toDouble()
		} else {
			return (hHigh.peek() + hLow.peek()) / 2.0
		}
	}
}


fun main(args: Array<String>) {
	val m = MedianFinder()
	m.addNum(1)
	m.addNum(2)
	println(m.findMedian() == 1.5)
	m.addNum(3)
	println(m.findMedian() == 2.0)
 }
