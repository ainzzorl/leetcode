import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class p041_test {
    private var solution: p041 = p041()

    @Test
    fun test() {
        assertEquals(3, solution.firstMissingPositive(intArrayOf(1, 2, 0)))
        assertEquals(2, solution.firstMissingPositive(intArrayOf(3, 4, -1, 1)))
        assertEquals(5, solution.firstMissingPositive(intArrayOf(4, 3, 1, 2)))
        assertEquals(5, solution.firstMissingPositive(intArrayOf(1, 2, 3, 4)))
        assertEquals(1, solution.firstMissingPositive(intArrayOf(4, 3, 2)))
        assertEquals(3, solution.firstMissingPositive(intArrayOf(2, -5, 2, 2, -100, 1, 1, -5, 4, 4, 1, 2, 5)))
        assertEquals(1, solution.firstMissingPositive(intArrayOf()))
        assertEquals(1, solution.firstMissingPositive(intArrayOf(1000000)))
    }
}