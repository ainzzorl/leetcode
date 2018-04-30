import org.junit.jupiter.api.Test
import solutions.p517
import kotlin.test.assertEquals

internal class p517_test {
    private var solution: p517 = solutions.p517()

    @Test
    fun positive() {
        assertEquals(3, solution.findMinMoves(intArrayOf(1, 0, 5)))
        assertEquals(3, solution.findMinMoves(intArrayOf(5, 0, 1)))

        assertEquals(2, solution.findMinMoves(intArrayOf(0, 3, 0)))

        assertEquals(1000, solution.findMinMoves(intArrayOf(3000, 1000)))
        assertEquals(1000, solution.findMinMoves(intArrayOf(1000, 3000)))

        assertEquals(1, solution.findMinMoves(intArrayOf(3, 2, 1, 1, 2, 3)))

        assertEquals(8, solution.findMinMoves(intArrayOf(0, 0, 11, 5)))
        assertEquals(8, solution.findMinMoves(intArrayOf(5, 11, 0, 0)))

        assertEquals(4, solution.findMinMoves(intArrayOf(2, 4, 8, 4, 2)))
    }

    @Test
    fun negative() {
        assertEquals(-1, solution.findMinMoves(intArrayOf(0, 2, 0)))
    }

    @Test
    fun edge() {
        assertEquals(0, solution.findMinMoves(intArrayOf(1)))
        assertEquals(0, solution.findMinMoves(intArrayOf(1, 1)))
    }
}
