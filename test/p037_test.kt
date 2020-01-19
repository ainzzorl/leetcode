import org.junit.jupiter.api.Test
import solutions.p037
import kotlin.test.assertTrue

internal class p037_test {
    private var solution: p037 = solutions.p037()

    @Test
    fun test() {
        val board = arrayOf(
                charArrayOf('5','3','.','.','7','.','.','.','.'),
                charArrayOf('6','.','.','1','9','5','.','.','.'),
                charArrayOf('.','9','8','.','.','.','.','6','.'),
                charArrayOf('8','.','.','.','6','.','.','.','3'),
                charArrayOf('4','.','.','8','.','3','.','.','1'),
                charArrayOf('7','.','.','.','2','.','.','.','6'),
                charArrayOf('.','6','.','.','.','.','2','8','.'),
                charArrayOf('.','.','.','4','1','9','.','.','5'),
                charArrayOf('.','.','.','.','8','.','.','7','9'))

        solution.solveSudoku(board)

        System.out.println(board)
        assertTrue(solution.isSolved(board))
    }
}