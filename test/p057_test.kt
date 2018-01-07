import org.junit.jupiter.api.Test
import solutions.p057
import util.Interval
import java.util.*
import kotlin.test.assertEquals

internal class p057_test {
    private var solution: p057 = solutions.p057()

    @Test
    fun insert() {
        assertEquals(
                Arrays.asList(Interval(1, 5), Interval(6, 9)),
                solution.insert(
                        Arrays.asList(Interval(1, 3), Interval(6, 9))
                , Interval(2, 5)))

        assertEquals(
                Arrays.asList(Interval(1, 2), Interval(3, 10), Interval(12, 16)),
                solution.insert(
                        Arrays.asList(Interval(1, 2), Interval(3, 5), Interval(6, 7), Interval(8, 10), Interval(12, 16))
                        , Interval(4, 9)))
    }
}