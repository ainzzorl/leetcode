package solutions

import java.util.*
import kotlin.math.max

public class p632 {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        var result = intArrayOf()
        var resultSize = Int.MAX_VALUE
        val numBuckets = nums.size
        val bucketIndexes = IntArray(numBuckets) { _ -> 1 }
        val pq = PriorityQueue<PQEntry>()
        var curMax = Int.MIN_VALUE
        for (bucketId in 0 until numBuckets) {
            val curValue = nums.get(bucketId).get(0)
            curMax = max(curMax, curValue)
            pq.add(PQEntry(curValue, bucketId))
        }
        while (true) {
            val minEntry = pq.poll()
            if (curMax - minEntry.value < resultSize) {
                resultSize = curMax - minEntry.value
                result = intArrayOf(minEntry.value, curMax)
            }
            val curBucketIndex = bucketIndexes.get(minEntry.bucketId)
            if (curBucketIndex >= nums.get(minEntry.bucketId).size) {
                break
            }
            bucketIndexes.set(minEntry.bucketId, curBucketIndex + 1)
            val newValue = nums.get(minEntry.bucketId).get(curBucketIndex)
            val newEntry = PQEntry(newValue, minEntry.bucketId)
            pq.offer(newEntry)
            curMax = max(curMax, newValue)
        }

        return result
    }

    data class PQEntry(val value: Int, val bucketId: Int) : Comparable<PQEntry> {
        override fun compareTo(other: PQEntry): Int {
            return value - other.value
        }
    }
}