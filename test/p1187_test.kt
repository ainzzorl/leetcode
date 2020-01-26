import org.junit.jupiter.api.Test
import solutions.p1187
import kotlin.test.assertEquals

internal class p1187_test {
    private var solution: p1187 = solutions.p1187()

    @Test
    fun example1() {
        assertEquals(1, solution.makeArrayIncreasing(intArrayOf(1, 5, 3, 6, 7), intArrayOf(1, 3, 2, 4)))
    }

    @Test
    fun example2() {
        assertEquals(2, solution.makeArrayIncreasing(intArrayOf(1, 5, 3, 6, 7), intArrayOf(4,3,1)))
    }

    @Test
    fun example3() {
        assertEquals(-1, solution.makeArrayIncreasing(intArrayOf(1, 5, 3, 6, 7), intArrayOf(1, 6, 3, 3)))
    }

    @Test
    fun failedTest1() {
        assertEquals(8, solution.makeArrayIncreasing(
                intArrayOf(5, 16, 19, 2, 1, 12, 7, 14, 5, 16),
                intArrayOf(6, 17, 4, 3, 6, 13, 4, 3, 18, 17, 16, 7, 14, 1, 16)))
    }

    @Test
    fun edge() {
        assertEquals(0, solution.makeArrayIncreasing(intArrayOf(1), intArrayOf(2)))
    }

    @Test
    fun alreadySorted() {
        assertEquals(0, solution.makeArrayIncreasing(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
    }
}
