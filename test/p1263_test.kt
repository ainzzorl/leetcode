import org.junit.jupiter.api.Test
import solutions.p1263
import kotlin.test.assertEquals

internal class p1263_test {
    private var solution: p1263 = solutions.p1263()

    @Test
    fun example1() {
        assertEquals(3, solution.minPushBox(arrayOf(
                charArrayOf('#','#','#','#','#','#'),
                charArrayOf('#','T','#','#','#','#'),
                charArrayOf('#','.','.','B','.','#'),
                charArrayOf('#','.','#','#','.','#'),
                charArrayOf('#','.','.','.','S','#'),
                charArrayOf('#','#','#','#','#','#')
        )))
    }

    @Test
    fun example2() {
        assertEquals(-1, solution.minPushBox(arrayOf(
                charArrayOf('#','#','#','#','#','#'),
                charArrayOf('#','T','#','#','#','#'),
                charArrayOf('#','.','.','B','.','#'),
                charArrayOf('#','#','#','#','.','#'),
                charArrayOf('#','.','.','.','S','#'),
                charArrayOf('#','#','#','#','#','#')
        )))
    }

    @Test
    fun example3() {
        assertEquals(5, solution.minPushBox(arrayOf(
                charArrayOf('#','#','#','#','#','#'),
                charArrayOf('#','T','.','.','#','#'),
                charArrayOf('#','.','#','B','.','#'),
                charArrayOf('#','.','.','.','.','#'),
                charArrayOf('#','.','.','.','S','#'),
                charArrayOf('#','#','#','#','#','#')
        )))
    }

    @Test
    fun example4() {
        assertEquals(-1, solution.minPushBox(arrayOf(
                charArrayOf('#','#','#','#','#','#','#'),
                charArrayOf('#','S','#','.','B','T','#'),
                charArrayOf('#','#','#','#','#','#','#')
        )))
    }

    @Test
    fun failed1() {
        assertEquals(7, solution.minPushBox(arrayOf(
                charArrayOf('#','.','.','#','#','#','#','#'),
                charArrayOf('#','.','.','T','#','.','.','#'),
                charArrayOf('#','.','.','.','#','B','.','#'),
                charArrayOf('#','.','.','.','.','.','.','#'),
                charArrayOf('#','.','.','.','#','.','S','#'),
                charArrayOf('#','.','.','#','#','#','#','#')
        )))
    }
}
