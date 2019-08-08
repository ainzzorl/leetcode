import org.junit.jupiter.api.Test
import solutions.p502
import kotlin.test.assertEquals

internal class p502_test {
    private var solution: p502 = solutions.p502()

    @Test
    fun sample() {
        assertEquals(4, solution.findMaximizedCapital(2, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1)))
    }

    @Test
    fun edge() {
        assertEquals(0, solution.findMaximizedCapital(0, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1)))
        assertEquals(0, solution.findMaximizedCapital(2, 0, intArrayOf(1, 2, 3), intArrayOf(100, 100, 100)))
    }
}