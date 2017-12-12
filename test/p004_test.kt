import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class p004_test {
    private var solution: p004 = p004()

    @Test
    fun odd() {
        assertEquals(2.0, solution.findMedianSortedArrays(
                intArrayOf(1, 3), intArrayOf(2)
        ))
        assertEquals(3.0, solution.findMedianSortedArrays(
                intArrayOf(2, 4), intArrayOf(1, 3, 5)
        ))
        assertEquals(10.0, solution.findMedianSortedArrays(
                intArrayOf(1, 10, 10, 10, 11), intArrayOf(2, 3, 10, 10, 100, 101)
        ))
        assertEquals(5.0, solution.findMedianSortedArrays(
                intArrayOf(1, 2, 3, 4, 5), intArrayOf(6, 7, 8, 9)
        ))
        assertEquals(5.0, solution.findMedianSortedArrays(
                intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8, 9)
        ))
        assertEquals(4.0, solution.findMedianSortedArrays(
                intArrayOf(1, 2, 3, 5, 6, 7), intArrayOf(4)
        ))
    }

    @Test
    fun even() {
        assertEquals(2.5, solution.findMedianSortedArrays(
                intArrayOf(1, 3), intArrayOf(2, 4)
        ))
        assertEquals(3.5, solution.findMedianSortedArrays(
                intArrayOf(2, 4, 6), intArrayOf(1, 3, 5)
        ))
        assertEquals(10.0, solution.findMedianSortedArrays(
                intArrayOf(1, 10, 10, 10, 11), intArrayOf(2, 3, 10, 10, 100)
        ))
        assertEquals(5.0, solution.findMedianSortedArrays(
                intArrayOf(1, 2, 3, 4), intArrayOf(6, 7, 8, 9)
        ))
        assertEquals(5.0, solution.findMedianSortedArrays(
                intArrayOf(1, 2, 3, 4, 6), intArrayOf(7, 8, 9)
        ))
    }

    @Test
    fun edge() {
        assertEquals(10.0, solution.findMedianSortedArrays(
                intArrayOf(10), intArrayOf()
        ))
        assertEquals(10.0, solution.findMedianSortedArrays(
                intArrayOf(), intArrayOf(10)
        ))
        assertEquals(10.0, solution.findMedianSortedArrays(
                intArrayOf(), intArrayOf(9, 10, 11)
        ))
        assertEquals(10.0, solution.findMedianSortedArrays(
                intArrayOf(9, 10, 11), intArrayOf()
        ))
    }
}