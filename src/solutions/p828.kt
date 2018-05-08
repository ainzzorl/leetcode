package solutions

// https://leetcode.com/problems/unique-letter-string/description/
class p828 {
    val MODULO = 1000000007

    fun uniqueLetterString(s: String): Int {
        val prev = IntArray(26)
        prev.fill(-1)
        val prevprev = IntArray(26)
        prevprev.fill(-1)
        var result = 0
        var rem = 0
        for (i in 0 until s.length) {
            val ord = s[i].toInt() - 'A'.toInt()
            val p = prev[ord]
            val pp = prevprev[ord]

            rem -= p - pp
            rem += i - p

            result += rem
            result %= MODULO

            prevprev[ord] = prev[ord]
            prev[ord] = i
        }
        return result
    }
}
