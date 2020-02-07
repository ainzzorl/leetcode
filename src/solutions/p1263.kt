package solutions

import java.util.PriorityQueue
import kotlin.collections.HashMap
import kotlin.Pair

// https://leetcode.com/problems/minimum-moves-to-move-a-box-to-their-target-location/
class p1263 {
    fun minPushBox(grid: Array<CharArray>): Int {
        val DX = listOf(0, 0, 1, -1)
        val DY = listOf(1, -1, 0, 0)

        var startPos = Pair(Pair(0, 0), Pair(0, 0))
        var target = Pair(0, 0)
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == 'S') {
                    startPos = startPos.copy(first = Pair(i, j))
                }
                if (grid[i][j] == 'B') {
                    startPos = startPos.copy(second = Pair(i, j))
                }
                if (grid[i][j] == 'T') {
                    target = Pair(i, j)
                }
            }
        }
        val visited = HashSet<Pair<Pair<Int, Int>, Pair<Int, Int>>>()
        val dists = HashMap<Pair<Pair<Int, Int>, Pair<Int, Int>>, Int>()
        val pq = PriorityQueue(compareBy<Pair<Pair<Int, Int>, Pair<Int, Int>>>({ dists[it] }))
        dists[startPos] = 0
        pq.add(startPos)

        while (!pq.isEmpty()) {
            val currentPos = pq.poll()
            val dist = dists[currentPos]!!
            visited.add(currentPos)

            if (currentPos.second == target) {
                return dist
            }

            for (i in 0 until 4) {
                val nxtPlayer = Pair(currentPos.first.first + DX[i], currentPos.first.second + DY[i])
                if (!available(nxtPlayer, grid)) {
                    continue
                }
                var nxtBox = currentPos.second
                var pushed = false
                if (nxtPlayer.equals(nxtBox)) {
                    nxtBox = Pair(currentPos.second.first + DX[i], currentPos.second.second + DY[i])
                    pushed = true
                }
                if (!available(nxtBox, grid)) {
                    continue
                }
                val nextPos = Pair(nxtPlayer, nxtBox)
                if (dists.contains(nextPos)) {
                    continue
                }
                var nextd = dist
                if (pushed) {
                    nextd++
                }
                dists[nextPos] = nextd
                pq.add(nextPos)
            }
        }
        return -1
    }

    private fun available(pos: Pair<Int, Int>, grid: Array<CharArray>): Boolean {
            return pos.first >= 0 && pos.first < grid.size && pos.second >= 0 && pos.second < grid[0].size && grid[pos.first][pos.second] != '#'
    }
}