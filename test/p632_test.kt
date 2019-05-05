import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import solutions.p632

internal class p632_test {
    private var solution: p632 = solutions.p632()

    @Test
    fun test() {
        Assertions.assertArrayEquals(
                intArrayOf(20, 24),
                solution.smallestRange(
                        listOf(
                                listOf(4, 10, 15, 24, 26),
                                listOf(0, 9, 12, 20),
                                listOf(5, 18, 22, 30)
                        )
                )
        )
        Assertions.assertArrayEquals(
                intArrayOf(1, 10),
                solution.smallestRange(
                        listOf(
                                listOf(1),
                                listOf(10),
                                listOf(5)
                        )
                )
        )
    }
}
