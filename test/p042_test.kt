import org.junit.jupiter.api.Test
import solutions.p042
import kotlin.test.assertEquals

internal class p042_test {
    private var solution: p042 = solutions.p042()

    @Test
    fun example() {
        assertEquals(6, solution.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    }

    @Test
    fun increase() {
        assertEquals(0, solution.trap(intArrayOf(0, 1, 1, 2)))
    }

    @Test
    fun decrease() {
        assertEquals(0, solution.trap(intArrayOf(2, 2, 1, 0)))
    }

    @Test
    fun one() {
        assertEquals(0, solution.trap(intArrayOf(2)))
    }

    @Test
    fun empty() {
        assertEquals(0, solution.trap(intArrayOf()))
    }

    @Test
    fun dip() {
        assertEquals(2000, solution.trap(intArrayOf(1000, 500, 0, 500, 1000, 400)))
    }
}