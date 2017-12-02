import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class p383_test {
    private var solution: Solution = Solution()

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