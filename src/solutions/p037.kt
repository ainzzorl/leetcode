package solutions

import java.util.Collections.sort

// https://leetcode.com/problems/sudoku-solver/
class p037 {
    companion object {
        val DIMENSION: Int = 9
        val ZERO_BYTE: Byte = 0
    }

    private var result: Board? = null

    fun solveSudoku(board: Array<CharArray>): Unit {
        solveSudoku(Board.fromChars(board))
        result?.toChars(board)
    }

    fun isSolved(board: Array<CharArray>): Boolean {
        return Board.fromChars(board).isSolved()
    }

    private fun solveSudoku(board: Board): Unit {
        if (result != null) {
            return
        }
        if (board.isSolved()) {
            result = board.deepCopy()
            return
        }

        val moves = board.getMoves()
        sort(moves)

        var i = 0
        val applied = mutableListOf<Pos>()
        while (i < moves.size && moves[i].vs.size == 1) {
            applied.add(Pos(moves[i].i, moves[i].j))
            board.set(moves[i].i, moves[i].j, moves[i].vs.first())
            i++
        }
        if (applied.isNotEmpty()) {
            solveSudoku(board)
            for (a in applied) {
                board.set(a.i, a.j, 0)
            }
            return
        }

        if (moves.isEmpty()) {
            return
        }
        val posMoves = moves.first()
        for (v in posMoves.vs) {
            board.set(posMoves.i, posMoves.j, v)
            solveSudoku(board)
        }
        board.set(posMoves.i, posMoves.j, 0)
    }

    private class Board(val data: Array<Array<Byte>>) {

        companion object {
            fun fromChars(inp: Array<CharArray>): Board {
                return Board(getData(inp))
            }

            fun getData(inp: Array<CharArray>): Array<Array<Byte>> {
                val rs = Array(DIMENSION) { arrayOf(ZERO_BYTE) }

                for (rowNum in 0 until DIMENSION) {
                    val inprow = inp[rowNum]
                    val row: Array<Byte> = Array(DIMENSION) { 0.toByte() }

                    for (i in 0 until 9) {
                        if (inprow[i] != '.') {
                            row[i] = (inprow[i] - '0').toByte()
                        }
                    }
                    rs[rowNum] = row
                }

                return rs
            }
        }

        fun set(i: Int, j: Int, v: Byte) {
            data[i][j] = v
        }

        fun getMoves(): List<PosMoves> {
            val result = mutableListOf<PosMoves>()

            val rowVals = Array(DIMENSION) { HashSet<Byte>() as MutableSet<Byte> }
            val columnVals = Array(DIMENSION) { HashSet<Byte>() as MutableSet<Byte> }
            val cellVals = Array(DIMENSION) { HashSet<Byte>() as MutableSet<Byte> }
            for (i in 0 until DIMENSION) {
                for (j in 0 until DIMENSION) {
                    if (data[i][j] != ZERO_BYTE) {
                        rowVals[i].add(data[i][j])
                        columnVals[j].add(data[i][j])
                        cellVals[cellByPosition(i, j)].add(data[i][j])
                    }
                }
            }

            for (i in 0 until DIMENSION) {
                for (j in 0 until DIMENSION) {
                    if (data[i][j] != ZERO_BYTE) {
                        continue
                    }

                    var vs = setOf<Byte>(1, 2, 3, 4, 5, 6, 7, 8, 9)
                    vs = vs.minus(rowVals[i])
                    vs = vs.minus(columnVals[j])
                    vs = vs.minus(cellVals[cellByPosition(i, j)])

                    result.add(PosMoves(i, j, vs))
                }
            }

            return result
        }

        fun isSolved(): Boolean {
            for (i in 0 until DIMENSION) {
                val rowVals: MutableSet<Byte> = mutableSetOf()
                val colVals: MutableSet<Byte> = mutableSetOf()
                val cellVals: MutableSet<Byte> = mutableSetOf()
                for (j in 0 until DIMENSION) {
                    if (data[i][j] == ZERO_BYTE) {
                        return false
                    }
                    rowVals.add(data[i][j])
                    colVals.add(data[i][j])
                    cellVals.add(data[rowByCell(i, j)][columnByCell(i, j)])
                }
                if (rowVals.size != DIMENSION) {
                    return false
                }
                if (colVals.size != DIMENSION) {
                    return false
                }
                if (cellVals.size != DIMENSION) {
                    return false
                }
            }
            return true
        }

        fun rowByCell(cellNumber: Int, numberInCell: Int): Int {
            return (cellNumber / 3) * 3 + numberInCell / 3
        }

        fun columnByCell(cellNumber: Int, numberInCell: Int): Int {
            return (cellNumber % 3) * 3 + numberInCell % 3
        }

        fun cellByPosition(i: Int, j: Int): Int {
            return (i / 3) * 3 + j / 3
        }

        fun toChars(out: Array<CharArray>) {
            for (i in 0 until DIMENSION) {
                for (j in 0 until DIMENSION) {
                    out[i][j] = '0' + data[i][j].toInt()
                }
            }
        }

        fun deepCopy(): Board {
            val newData = Array(DIMENSION) { arrayOf(ZERO_BYTE) }

            for (i in 0 until DIMENSION) {
                newData[i] = data[i].copyOf()
            }

            return Board(newData)
        }
    }

    data class PosMoves(val i: Int, val j: Int, val vs: Set<Byte>) : Comparable<PosMoves> {
        override fun compareTo(other: PosMoves): Int {
            return this.vs.size - other.vs.size
        }
    }

    data class Pos(val i: Int, val j: Int)
}