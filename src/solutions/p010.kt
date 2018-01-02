package solutions

// https://leetcode.com/problems/regular-expression-matching/description/
class p010 {
    fun isMatch(s: String, p: String): Boolean {
        // match[i][j] = first i chars of s match the first j chars of p
        val match = Array(s.length + 1, { BooleanArray(p.length + 1) })
        match[0][0] = true
        for (i in 1..s.length) {
            match[i][0] = false
        }
        for (i in 1..p.length) {
            if (p[i - 1] == '*') {
                match[0][i] = match[0][i - 2]
            } else {
                match[0][i] = false
            }
        }
        for (i in 1..s.length) {
            for (j in 1..p.length) {
                when {
                    p[j - 1] == '*' -> {
                        match[i][j] = false
                        for (k in i downTo 0) {
                            match[i][j] = match[i][j] || match[k][j - 2]
                            if (k == 0 || !isMatch(s[k - 1], p[j - 2])) {
                                break
                            }
                        }
                    }
                    else -> {
                        match[i][j] = isMatch(s[i - 1], p[j - 1]) && match[i - 1][j - 1]
                    }
                }
            }
        }
        return match[s.length][p.length]
    }

    private fun isMatch(c1: Char, c2: Char): Boolean {
        return c1 == c2 || c1 == '.' || c2 == '.'
    }
}
