import org.junit.jupiter.api.Test
import solutions.p010
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class p010_test {
    private var solution: p010 = solutions.p010()

    @Test
    fun match() {
        assertTrue(solution.isMatch("aa", "aa"))
        assertTrue(solution.isMatch("aa", "a*"))
        assertTrue(solution.isMatch("aa", ".*"))
        assertTrue(solution.isMatch("ab", ".*"))
        assertTrue(solution.isMatch("ab", "a.*b"))
        assertTrue(solution.isMatch("aab", "c*a*b"))
        assertTrue(solution.isMatch("aaa", "ab*ac*a"))
    }

    @Test
    fun noMatch() {
        assertFalse(solution.isMatch("aa", "a"))
        assertFalse(solution.isMatch("aaa", "aa"))
        assertFalse(solution.isMatch("aa", "aaa"))
        assertFalse(solution.isMatch("a", "ab*a"))
    }

    @Test
    fun edge() {
        assertTrue(solution.isMatch("", ""))
        assertFalse(solution.isMatch("a", ""))
        assertFalse(solution.isMatch("", "a"))
        assertTrue(solution.isMatch("", ".*"))
        assertTrue(solution.isMatch("", "a*"))
        assertTrue(solution.isMatch("", "a*a*"))
        assertFalse(solution.isMatch("", "a*a*a"))
    }
}