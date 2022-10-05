/* The knows API is defined in the parent class Relation.
      fun knows(a: Int, b: Int) : Boolean {} */
abstract class Relation {
    //var g = arrayOf(intArrayOf(1,1,0),intArrayOf(0,1,0),intArrayOf(1,1,1))
    var g = arrayOf(intArrayOf(1,0,1),intArrayOf(1,1,0),intArrayOf(0,1,1))
    fun knows(a: Int, b: Int): Boolean {
        return g[a][b] == 1
    }
    abstract fun findCelebrity(n: Int) : Int
}
	
class Solution: Relation() {
    override fun findCelebrity(n: Int) : Int {
        val knows = BooleanArray(n)
        var i = 0
        var j: Int
        while(i < n) {
            j = 0
            while(j < n) {
                if (i != j) {
                    if (knows(i, j)) {
                        knows[i] = true
                        j = n
                    }
                }
                j += 1
            }
            i += 1
        }
        i = 0
        while(i < n) {
            if (!knows[i]) {
                j = 0
                while(j < n) {
                    if (j != i) {
                        if(!knows(j, i)) {
                            j = n + 1
                            break
                        }
                    }
                    j += 1
                }
                if (j == n) {
                    return i
                }
            }
            i += 1
        }
        return -1
	}
}
fun main() {
    println(Solution().findCelebrity(3))
}
