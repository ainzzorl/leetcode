package solutions

// https://leetcode.com/problems/making-a-large-island/description/
class p827 {
    var islandIds: ArrayList<IntArray> = ArrayList()
    var n = 0
    var m = 0

    val di = intArrayOf(1, -1, 0, 0)
    val dj = intArrayOf(0, 0, 1, -1)

    fun largestIsland(grid: Array<IntArray>): Int {
        n = grid.size
        m = grid[0].size
        var islandIndex = 0
        islandIds = ArrayList(n)
        for (i in 0 until n) {
            islandIds.add(IntArray(m))
        }
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (grid[i][j] != 0 && islandIds[i][j] == 0) {
                    dfs(grid, i, j, ++islandIndex)
                }
            }
        }
        val sizes = IntArray(islandIndex + 1)
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (islandIds[i][j] != 0) {
                   sizes[islandIds[i][j]]++
                }
            }
        }
        var result = 1
        for (i in 0 until n) {
            for (j in 0 until m) {
                var surround = 1 - grid[i][j]
                val used = HashSet<Int>()
                for (k in 0 until 4) {
                    if (inside(i + di[k], j + dj[k]) && islandIds[i + di[k]][j + dj[k]] != 0 && !used.contains(islandIds[i + di[k]][j + dj[k]])) {
                        used.add(islandIds[i + di[k]][j + dj[k]])
                        surround += sizes[islandIds[i + di[k]][j + dj[k]]]
                    }
                }
                result = Math.max(result, surround)
            }
        }
        return result
    }

    private fun dfs(grid: Array<IntArray>, i: Int, j: Int, islandIndex: Int) {
        islandIds[i][j] = islandIndex
        (0 until 4)
                .filter { inside(i + di[it], j + dj[it]) && islandIds[i + di[it]][j + dj[it]] == 0 && grid[i + di[it]][j + dj[it]] == 1 }
                .forEach { dfs(grid, i + di[it], j + dj[it], islandIndex) }
    }

    private fun inside(i: Int, j: Int): Boolean {
        return i in 0..(n - 1) && j in 0..(m - 1)
    }
}
