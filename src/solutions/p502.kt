package solutions

import java.util.PriorityQueue
import kotlin.collections.ArrayList

// https://leetcode.com/problems/ipo/
class p502 {
    fun findMaximizedCapital(k: Int, W: Int, Profits: IntArray, Capital: IntArray): Int {
        val byProfit = PriorityQueue<Project> { x: Project, y: Project -> y.profit - x.profit }
        val byCapital = ArrayList<Project>()
        for (i in 0 until Profits.size) {
            byCapital.add(Project(Profits[i], Capital[i]))
        }
        byCapital.sortWith(Comparator { x: Project, y: Project -> x.capital - y.capital })
        var currentIndexByCapital = 0
        var currentCapital = W
        while (currentIndexByCapital < byCapital.size && currentCapital >= byCapital[currentIndexByCapital].capital) {
            byProfit.add(byCapital[currentIndexByCapital])
            currentIndexByCapital++
        }
        for (i in 0 until k) {
            val nextProject = byProfit.poll() ?: break
            currentCapital += nextProject.profit
            while (currentIndexByCapital < byCapital.size && currentCapital >= byCapital[currentIndexByCapital].capital) {
                byProfit.add(byCapital[currentIndexByCapital])
                currentIndexByCapital++
            }
        }
        return currentCapital
    }

    class Project(val profit: Int, val capital: Int)
}