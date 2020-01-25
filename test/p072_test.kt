import org.junit.jupiter.api.Test
import solutions.p072
import kotlin.test.assertEquals

internal class p072_test {
    private var solution: p072 = solutions.p072()

    @Test
    fun example1() {
        assertEquals(3, solution.minDistance("horse", "ros"))
    }

    @Test
    fun example2() {
        assertEquals(5, solution.minDistance("intention", "execution"))
    }

    @Test
    fun edge() {
        assertEquals(0, solution.minDistance("hello", "hello"))
        assertEquals(0, solution.minDistance("", ""))
        assertEquals(1, solution.minDistance("", "a"))
    }
}