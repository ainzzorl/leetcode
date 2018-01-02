import org.junit.jupiter.api.Test
import solutions.p383
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class p383_test {
    private var solution: p383 = solutions.p383()

    @Test
    fun positive() {
        assertTrue(solution.canConstruct("aa", "aab"))
        assertTrue(solution.canConstruct("abc", "cba"))
    }

    @Test
    fun negative() {
        assertFalse(solution.canConstruct("a", "b"))
        assertFalse(solution.canConstruct("aa", "ab"))
    }

    @Test
    fun edge() {
        assertTrue(solution.canConstruct("", ""))
        assertTrue(solution.canConstruct("", "abc"))
        assertFalse(solution.canConstruct("a", ""))
    }
}