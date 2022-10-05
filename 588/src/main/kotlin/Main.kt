// https://leetcode.com/problemset/all?search=588
// https://leetcode.com/problems/design-in-memory-file-system
import java.util.TreeSet
class FileSystem() {
		sealed class FSNode(var name: String) {
			class FileNode(var fileName: String, var content: StringBuilder = StringBuilder()): FSNode(fileName)
			class DirNode(var dirName: String): FSNode(dirName) {
				val childNodes = TreeSet<FSNode>(){node1, node2 -> node1.name.compareTo(node2.name) }
			}
		}
		private val root = FSNode.DirNode("/")

		private fun getLeafNode(path: String): FSNode {
			val segments = path.split("/").filter { it.isNotEmpty() }
			var node: FSNode = root
			var needle = FSNode.FileNode("")
			for((index, segment) in segments.withIndex()) {
				node = when(node) {
					is FSNode.DirNode -> {
						needle.name = segment
						val next = node.childNodes.ceiling(needle)
						if (next == null || next.name > segment) {
							throw IllegalStateException("Invalid Path")
						}
						next
					}
					is FSNode.FileNode -> {
						if (index != segments.lastIndex) {
							throw IllegalStateException("Invalid Path: expecting directory path, got filepath $segment ")
						}
						node
					}
				}
			}
			return node
		}
		
		fun ls(path: String): List<String> {
			return try {
				when(val node = getLeafNode(path)) {
					is FSNode.FileNode -> listOf(node.name)
					is FSNode.DirNode -> node.childNodes.toList().map{ it.name }
				}
			} catch(e: Exception) {
				emptyList()
			}
		}

		private fun mkdirForPathSegments(segments: List<String>): FSNode {
			var node:FSNode = root
			var needle = FSNode.FileNode("")
			for(segment in segments) {
				node = when(node) {
					is FSNode.DirNode -> {
						needle.name = segment
						var next = node.childNodes.ceiling(needle)
						if (next == null || next.name > segment) {
							next = FSNode.DirNode(segment)
							node.childNodes.add(next)
						}
						next
					}
					else -> {
						throw IllegalStateException("Invalid path: $segment is a file")
					}
				}
			}
			return node
		}

    fun mkdir(path: String) {
		 	mkdirForPathSegments(path.split("/").filter { it.isNotEmpty() })
		}

    fun addContentToFile(filePath: String, content: String) {
			val segments = filePath.split("/").filter { it.isNotEmpty() }
			when(val dirNode = mkdirForPathSegments(segments.subList(0, segments.lastIndex))) {
				is FSNode.DirNode -> {
					var needle = FSNode.FileNode(segments.last())
					var fileNode = dirNode.childNodes.ceiling(needle)
					if (fileNode == null || fileNode.name > needle.name) {
						dirNode.childNodes.add(needle)
						fileNode = needle
					}
					if (fileNode is FSNode.FileNode) {
						fileNode.content.append(content)
					} else {
						throw IllegalStateException("${segments.last()} is a directory")
					}
				}
				else -> {
					throw IllegalStateException("Invalid path: $filePath is not a file")
				}
			}
    }

	fun readContentFromFile(filePath: String): String {
		return try {
			when(val leafNode = getLeafNode(filePath)) {
				is FSNode.FileNode -> leafNode.content.toString()
				else -> throw IllegalStateException("$filePath is a directory")
			}
		} catch(e: Exception) {
			println(e)
			""
		}
	}
		
}

fun main(args: Array<String>) {
	val fs = FileSystem()
	//println(fs.ls("/"))
	fs.mkdir("/a/b/c")
	fs.mkdir("/a/d/e")
	fs.mkdir("/a/c/d")
	fs.mkdir("/")
	fs.mkdir("/a/j/k")
	fs.mkdir("/b/j/k")
	//println(fs.ls("/"))
	//println(fs.ls("/a/b/e"))
	fs.addContentToFile("/a/b/c/d", "hello")
	println(fs.ls("/a/b/c"))
	println(fs.readContentFromFile("/a/b/c/d"))
	fs.addContentToFile("/a/b/c/d", "Hi")
	println(fs.readContentFromFile("/a/b/c/d"))
	fs.mkdir("/a/b/c/d/e")
}
