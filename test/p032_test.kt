import org.junit.jupiter.api.Test
import solutions.p032
import kotlin.test.assertEquals

internal class p032_test {
    private var solution: p032 = solutions.p032()

    @Test
    fun test() {
        assertEquals(2, solution.longestValidParentheses("(()"))
        assertEquals(4, solution.longestValidParentheses(")()())"))
        assertEquals(6, solution.longestValidParentheses("((()))"))
        assertEquals(6, solution.longestValidParentheses("()()()"))
        assertEquals(0, solution.longestValidParentheses(")))((("))
        assertEquals(0, solution.longestValidParentheses(""))
        assertEquals(2, solution.longestValidParentheses("()"))
    }
}