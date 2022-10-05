//https://leetcode.com/problemset/all?search=1628
import com.leet.TreeBuilder
import com.leet.Node
/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
fun main() {
    println(
        TreeBuilder()
        .buildTree(arrayOf("4","5","7","2","+","-","*"))
        .evaluate()
    )
    println(
        TreeBuilder()
        .buildTree(arrayOf("3","4","+","2","*","7","/"))
        .evaluate()
    ) 
}
