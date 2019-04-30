import org.junit.jupiter.api.Test;
import solutions.p164;
import kotlin.test.assertEquals

public class p164_test {
    private var solution: p164 = solutions.p164()

    @Test
    fun test() {
        assertEquals(3, solution.maximumGap(intArrayOf(3, 6, 9, 1)))
        assertEquals(0, solution.maximumGap(intArrayOf()))
        assertEquals(0, solution.maximumGap(intArrayOf(123)))
        assertEquals(500001, solution.maximumGap(intArrayOf(1000000, 499999, 0)))
        assertEquals(0, solution.maximumGap(intArrayOf(3, 3, 3)))
        assertEquals(4, solution.maximumGap(intArrayOf(1, 1, 1, 1, 1, 5, 5, 5, 5, 5)))
    }
}
