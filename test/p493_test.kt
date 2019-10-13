import org.junit.jupiter.api.Test
import solutions.p493
import kotlin.test.assertEquals

internal class p493_test {
    private var solution: p493 = solutions.p493()

    @Test
    fun normal() {
        assertEquals(3, solution.reversePairs(intArrayOf(2, 4, 3, 5, 1)))
    }

    @Test
    fun edge() {
        assertEquals(0, solution.reversePairs(intArrayOf()))
        assertEquals(0, solution.reversePairs(intArrayOf(1)))
        assertEquals(0, solution.reversePairs(intArrayOf(1, 10)))
        assertEquals(1, solution.reversePairs(intArrayOf(10, 1)))
        assertEquals(0, solution.reversePairs(intArrayOf(2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647)))
    }
}