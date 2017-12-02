//https://leetcode.com/problems/first-missing-positive/description/
class p041 {
    fun firstMissingPositive(nums: IntArray): Int {
        for (i in 0 until nums.size) {
            var pos = i
            var prevValue = 0
            while (pos >= 0 && pos < nums.size && nums[pos] != pos + 1) {
                val value = nums[pos]
                nums[pos] = prevValue
                prevValue = value
                pos = value - 1
            }
        }
        return (0 until nums.size)
                .firstOrNull { nums[it] <= 0 }
                ?.let { it + 1 }
                ?: nums.size + 1
    }
}