package solutions

// https://leetcode.com/problems/trapping-rain-water/
class p042 {
    fun trap(height: IntArray): Int {
        var result = 0

        var max = 0
        val leftMaxs = IntArray(height.size)
        for (i in 0 until height.size) {
            max = Math.max(max, height[i])
            leftMaxs[i] = max
        }

        val rightMaxs = IntArray(height.size)
        max = 0
        for (i in height.size - 1 downTo 0) {
            max = Math.max(max, height[i])
            rightMaxs[i] = max
        }

        for (i in 0 until height.size) {
            if (height[i] >= leftMaxs[i] && height[i] >= rightMaxs[i]) {
                continue
            }

            result += Math.min(leftMaxs[i], rightMaxs[i]) - height[i]
        }

        return result
    }
}