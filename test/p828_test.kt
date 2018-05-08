import org.junit.jupiter.api.Test
import solutions.p828
import kotlin.test.assertEquals

internal class p828_test {
    private var solution: p828 = solutions.p828()

    @Test
    fun positive() {
        assertEquals(10, solution.uniqueLetterString("ABC"))
        assertEquals(8, solution.uniqueLetterString("ABA"))
        assertEquals(30, solution.uniqueLetterString("LETTER"))
    }

    @Test
    fun edge() {
        assertEquals(0, solution.uniqueLetterString(""))
        assertEquals(1, solution.uniqueLetterString("A"))
        assertEquals(3, solution.uniqueLetterString("AAA"))
    }
}
