import org.junit.Test
import org.junit.Assert

class MainTest{
  @Test 
  fun `Example 1`() {
    val sentences = arrayOf("i love you", "island", "iroman", "i love leetcode")
    val times = intArrayOf(5, 3, 2, 2)
    val autocompleteSystem = AutocompleteSystem(sentences, times)
    var actual = autocompleteSystem.input('i')
    var expected = arrayOf("i love you", "island", "i love leetcode")
    Assert.assertEquals(expected.toList(), actual.toList())
    actual = autocompleteSystem.input(' ')
    expected = arrayOf("i love you","i love leetcode")
    Assert.assertEquals(expected.toList(), actual.toList())
    actual = autocompleteSystem.input('a')
    expected = arrayOf<String>()
    Assert.assertEquals(expected.toList(), actual.toList())
    actual = autocompleteSystem.input('#')
    expected = arrayOf<String>()
    Assert.assertEquals(expected.toList(), actual.toList())

    autocompleteSystem.input('i')
    autocompleteSystem.input(' ')
    actual = autocompleteSystem.input('a')
    expected = arrayOf("i a")
    Assert.assertEquals(expected.toList(), actual.toList())

  }
}