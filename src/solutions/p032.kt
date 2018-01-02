package solutions

// https://leetcode.com/problems/longest-valid-parentheses/description/
class p032 {
    fun longestValidParentheses(s: String): Int {
        var res = 0
        for (left in 0 until s.length) {
            var sum = 0
            for (right in left until s.length) {
                sum += if (s[right] == '(') 1 else -1
                if (sum < 0) {
                    break
                }
                if (sum == 0) {
                    val len = right - left + 1
                    res = if (len > res) len else res
                }
            }
        }
        return res
    }
}
