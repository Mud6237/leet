//https://leetcode.com/problemset/all?search=2102
//https://leetcode.com/problems/sequentially-ordinal-rank-tracker/

class RBTree {
	private enum class Color {
		Red,
		Black
	}

	private data class RBNode(
		val key: String,
		var score: Int,
		var size: Int,
		var color: Color
	)  {
		
		var parent: RBNode
		var left: RBNode
		var right: RBNode

		constructor(
			k: String,
			s: Int,
			sz: Int,
			c: Color,
			l: RBNode,
			r: RBNode,
			p: RBNode
		): this(k, s, sz, c) {
			this.parent = p
			this.left = l
			this.right = r
		}
		init {
			parent = this
			left = this
			right = this
		}
	}

	private val sentinel = RBNode(
		"<sentinel>",
		0,
		0,
		Color.Black
	)

	private var root = sentinel
	private var comparator = compareBy<Pair<Int, String>>({ -it.first }).thenBy({ it.second })

	private fun leftRotate(x: RBNode) {
		val y = x.right
		x.right = y.left
		if (y.left !== sentinel) {
			y.left.parent = x
		}
		y.parent = x.parent
		if (x.parent === sentinel) {
			root = y
		} else if (x === x.parent.left) {
			x.parent.left = y
		} else {
			x.parent.right = y
		}
		y.left = x
		x.parent = y
		x.size = x.left.size + x.right.size + 1
		y.size = y.right.size + y.left.size + 1
	}

	private fun rightRotate(x: RBNode) {
		val y = x.left
		x.left = y.right
		if (y.right !== sentinel) {
			y.right.parent = x
		}
		y.parent = x.parent
		if (x.parent === sentinel) {
			root = y
		} else if (x === x.parent.left) {
			x.parent.left = y
		} else  {
			x.parent.right = y
		}
		y.right = x
		x.parent = y
		x.size = x.left.size + x.right.size + 1
		y.size = y.left.size + y.right.size + 1
	}

	private fun insertFixUp(znode: RBNode) {
		var z = znode
		while(z.parent.color == Color.Red) {
			if (z.parent === z.parent.parent.left) {
				val y = z.parent.parent.right
				if (y.color == Color.Red) {
					z.parent.color = Color.Black
					y.color = Color.Black
					z.parent.parent.color = Color.Red
					z = z.parent.parent
				} else {
					if (z === z.parent.right) {
						z = z.parent
						leftRotate(z)
					}
					z.parent.color = Color.Black
					z.parent.parent.color = Color.Red
					rightRotate(z.parent.parent)
				}
			} else {
				val y = z.parent.parent.left
				if (y.color == Color.Red) {
					z.parent.color = Color.Black
					y.color = Color.Black
					z.parent.parent.color = Color.Red
					z = z.parent.parent
				} else  {
					if (z === z.parent.left) {
						z = z.parent
						rightRotate(z)
					}
					z.parent.color = Color.Black
					z.parent.parent.color = Color.Red
					leftRotate(z.parent.parent)
				}
			}
		}
		root.color = Color.Black
	}

	fun insert(key: String, score: Int) {
		var y = sentinel
		var x = root
		var zPair = (score to key)
		while(x !== sentinel) {
			y = x
			x.size += 1
			val order = comparator.compare(zPair, (x.score to x.key))
			if (order < 0) {
				x = x.left
			} else {
				x = x.right
			}
		}
		val z = RBNode(
			key,
			score,
			1,
			Color.Red,
			sentinel,
			sentinel,
			y
		)
		if (y === sentinel) {
			root = z
		} else if (comparator.compare(zPair, (y.score to y.key)) < 0) {
			y.left = z
		} else {
			y.right = z
		}
		insertFixUp(z)
	}

	fun select(i: Int): String {
		var x = root
		var r = x.left.size + 1
		var k = i
		while(k != r) {
			if (k < r) {
				x = x.left
			} else {
				x = x.right
				k = k-r
			}
			r = x.left.size + 1
		}
		return x.key
	}
}


class SORTracker() {
	var rank = 0
	private val rbTree = RBTree()

	fun add(name: String, score: Int) {
		rbTree.insert(name, score)
	}

	fun get(): String {
		rank += 1
		return rbTree.select(rank)
	}
}

