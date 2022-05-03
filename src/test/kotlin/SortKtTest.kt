import org.junit.Test

class SortKtTest {
    @Test
    fun test1() {
        val actual = mergeSort(listOf(2, 5, 3, 1, 8, 4, 9, 7))
        assert(actual == listOf(1, 2, 3, 4, 5, 7, 8, 9))
    }

    @Test
    fun test2() {
        val actual = mergeSort(listOf(12, 25, 3, 11, 28, 14, 9, 17, 13, 5, 19))
        assert(actual == listOf(3, 5, 9, 11, 12, 13, 14, 17, 19, 25, 28))
    }
}