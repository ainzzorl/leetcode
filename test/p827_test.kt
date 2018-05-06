import org.junit.jupiter.api.Test
import solutions.p827
import kotlin.test.assertEquals

internal class p827_test {
    private var solution: p827 = solutions.p827()

    @Test
    fun positive() {
        assertEquals(3, solution.largestIsland(arrayOf(
                intArrayOf(1, 0),
                intArrayOf(0, 1)
        )))
        assertEquals(4, solution.largestIsland(arrayOf(
                intArrayOf(1, 1),
                intArrayOf(0, 1)
        )))
        assertEquals(4, solution.largestIsland(arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 1)
        )))
    }

    @Test
    fun edge() {
        assertEquals(1, solution.largestIsland(arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 0)
        )))
        assertEquals(5, solution.largestIsland(arrayOf(
                intArrayOf(0, 1, 0),
                intArrayOf(1, 0, 1),
                intArrayOf(0, 1, 0)
        )))
    }
}
