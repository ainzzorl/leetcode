package solutions

// https://leetcode.com/problems/sudoku-solver/
class p037 {
    fun solveSudoku(board: Array<CharArray>): Unit {

    }

    fun isSolved(board: Array<CharArray>): Boolean {
        return Board(board).isSolved()
    }

    private class Board(inp: Array<CharArray> ) {
        private var data: Array<Array<Byte>> = emptyArray()

        init {
            for (inprow in inp) {
                val row: Array<Byte> = Array(9) { 0.toByte() }

                for (i in 0 until 9) {
                    if (inprow[i] != '.') {
                        row[i] = (inprow[i] - '0').toByte()
                    }
                }
            }
        }

        fun isSolved(): Boolean {
            return false
        }
    }
}