package solutions

// https://leetcode.com/problems/edit-distance/
class p072 {
    fun minDistance(word1: String, word2: String): Int {
        if (word1.isEmpty() || word2.isEmpty()) {
            return Math.max(word1.length, word2.length)
        }
        val dist = Array(word1.length + 1) { IntArray(word2.length + 1) { 0 } }

        for (i in 0..word1.length) {
            for (j in 0..word2.length) {
                if (i == 0) {
                    dist[i][j] = j
                    continue
                }
                if (j == 0) {
                    dist[i][j] = i
                    continue
                }

                dist[i][j] = i + j
                if (word1[i - 1] == word2[j - 1]) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j - 1])
                }
                dist[i][j] = Math.min(dist[i][j], dist[i - 1][j - 1] + 1)
                dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1)
                dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1)
            }
        }
        return dist[word1.length][word2.length]
    }
}