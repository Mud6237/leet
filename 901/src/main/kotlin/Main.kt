class StockSpanner() {
	private val stack = mutableListOf<Pair<Int, Int>>()
	fun next(price: Int): Int {
		var span = 1
		while(stack.isNotEmpty() && stack.last().first <= price) {
			span += stack.removeAt(stack.lastIndex).second
		}
		stack.add(price to span)
		return span
	}
}
