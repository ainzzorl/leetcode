package solutions

import java.lang.StringBuilder
import java.math.BigInteger

// https://leetcode.com/problems/find-the-closest-palindrome/
class p564 {
    fun nearestPalindromic(n: String): String {
        if (n.length > 1) {
            if (isPowerOf10(n) || isPowerOf10(n.substring(0, n.length - 1)) && n[n.length - 1] == '1') {
                var result = StringBuilder()
                for (i in 0 until n.length - 1) {
                    result.append('9')
                }
                return result.toString()
            }
        }

        var result = StringBuilder(n)

        for (i in 0 until n.length/2) {
            result.setCharAt(n.length - i - 1, result[i])
        }

        var best = result.toString()
        for (c in n[(n.length - 1)/2] - 1 .. n[(n.length - 1)/2] + 1) {
            if (c in '0'..'9') {
                for (i in (n.length - 1)/2 .. n.length/2) {
                    result[i] = c
                }
                if (isBetter(result.toString(), best, n)) {
                    best = result.toString()
                }
            }
        }

        if (best == n) {
            result = StringBuilder(best)
            for (i in (n.length - 1)/2 .. n.length/2) {
                if (result[i] == '0') {
                    result[i] = '1'
                } else {
                    result[i] = result[i] - 1
                }
            }
            best = result.toString()
        }

        if (isBetter(nextInLen(n), best, n)) {
            return nextInLen(n)
        }

        return best
    }

    private fun isBetter(candidate: String, current: String, target: String): Boolean {
        val candInt = BigInteger(candidate)
        val curInt = BigInteger(current)
        val targetInt = BigInteger(target)

        return candInt.minus(targetInt).abs() < curInt.minus(targetInt).abs()
                || (candInt.minus(targetInt).abs() == curInt.minus(targetInt).abs() && candInt < curInt)
    }

    private fun isPowerOf10(n: String): Boolean {
        for (i in 0 until n.length) {
            if (i == 0 && n[i] != '1' || i != 0 && n[i] != '0') {
                return false
            }
        }
        return true
    }

    private fun nextInLen(n: String): String {
        var result = StringBuilder("1")
        for (i in 0 until n.length - 1) {
            result.append('0')
        }
        result.append("1")
        return result.toString()
    }
}
