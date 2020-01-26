package solutions

class p1187 {
    fun makeArrayIncreasing(arr1: IntArray, arr2: IntArray): Int {
        arr2.sort()

        val MAX = arr1.size + 1
        val dp = Array(arr1.size + 1) { IntArray(arr2.size + 1) { MAX } }
        val inPlace = IntArray(arr1.size + 1) { MAX }

        val prevDiff = IntArray(arr2.size + 1)
        prevDiff[0] = -1
        prevDiff[1] = 0
        for (i in 2..arr2.size) {
            if (arr2[i - 1] > arr2[i - 2]) {
                prevDiff[i] = i - 1
            } else {
                prevDiff[i] = prevDiff[i - 1]
            }
        }

        for (i in 0..arr1.size) {
            for (j in 0..arr2.size) {
                if (i == 0) {
                    inPlace[i] = 0
                    dp[i][j] = 0
                    continue
                }
                if (j == 0) {
                    dp[i][j] = MAX
                    continue
                }

                if (i == 1 || arr1[i - 1] > arr1[i - 2]) {
                    inPlace[i] = Math.min(inPlace[i], inPlace[i - 1])
                }

                if (arr1[i - 1] > arr2[j - 1] && (j == 1 || arr2[j - 1] > arr2[j - 2])) {
                    inPlace[i] = Math.min(inPlace[i], dp[i - 1][j])
                }

                dp[i][j] = Math.min(dp[i][j], dp[i - 1][prevDiff[j]] + 1)

                if (i == 1 || arr2[j - 1] > arr1[i - 2]) {
                    dp[i][j] = Math.min(dp[i][j], inPlace[i - 1] + 1)
                }
            }
        }

        val result = Math.min(inPlace.last(), dp[arr1.size][arr2.size])

        return if (result > arr1.size) -1 else result
    }
}