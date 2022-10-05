//https://leetcode.com/problemset/all?search=240
//https://leetcode.com/problems/search-a-2d-matrix-ii/
class Solution {
	fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
		var i = matrix.lastIndex
		var j = 0
		while(i >= 0 && j < matrix[i].size) {
			if (matrix[i][j] == target) {
				return true
			} else if (target < matrix[i][j]) {
				i = i-1
			} else {
				j = j+1
			}
		}
		return false	
	}
}