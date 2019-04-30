package solutions;

import kotlin.math.max
import kotlin.math.min

public class p164 {
    fun maximumGap(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0
        }
        val (min, max) = getMinMax(nums)
        if (min == max) {
            return 0
        }
        val bucketSize = kotlin.math.max(1, (max - min) / (nums.size - 1))
        val bucketToMinMax = HashMap<Int, Pair<Int, Int>>(1)
        var maxBucketId = 0
        for (num in nums) {
            val bucketId = (num - min) / bucketSize
            if (bucketToMinMax.containsKey(bucketId)) {
                val oldBucket = bucketToMinMax.getValue(bucketId)
                val newBucket = Pair(min(num, oldBucket.component1()), max(num, oldBucket.component2()))
                bucketToMinMax.put(bucketId, newBucket)
            } else {
                bucketToMinMax.put(bucketId, Pair(num, num))
            }
            maxBucketId = kotlin.math.max(maxBucketId, bucketId)
        }

        var prevMax = Int.MAX_VALUE
        var result = bucketSize
        for (buckedId in 0..maxBucketId) {
            if (!bucketToMinMax.containsKey(buckedId)) {
                continue
            }
            val (bucketMin, bucketMax) = bucketToMinMax.getValue(buckedId)
            if (bucketMin - prevMax > result) {
                result = bucketMin - prevMax
            }
            prevMax = bucketMax
        }
        return result
    }

    private fun getMinMax(nums: IntArray): Pair<Int, Int> {
        var min = nums[0]
        var max = nums[0]
        for (n in nums) {
            if (n < min) {
                min = n
            }
            if (n > max) {
                max = n
            }
        }
        return Pair(min, max)
    }
}
