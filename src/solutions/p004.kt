package solutions

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
class p004 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val median = findMedian(nums1, nums2)
        return if (median != null) {
            median;
        } else {
            findMedian(nums2, nums1)!!
        }
    }

    // Assume that the median (or its smaller term) is in the first array.
    // Return null if it's not.
    fun findMedian(withMedian: IntArray, withoutMedian: IntArray): Double? {
        val targetIndex = (withMedian.size + withoutMedian.size - 1) / 2
        var low = 0
        var high = withMedian.size - 1
        while (low <= high) {
            val index1 = (low + high) / 2
            val value1 = withMedian[index1]
            val index2 = targetIndex - index1
            if (index2 > withoutMedian.size) {
                low = index1 + 1
                continue
            }
            if (index2 < 0) {
                high = index1 - 1
                continue
            }
            val value2 = if (index2 < withoutMedian.size) withoutMedian[index2] else Integer.MAX_VALUE
            if (value1 <= value2 && (index2 == 0 || value1 >= withoutMedian[index2 - 1])) {
                return if ((withMedian.size + withoutMedian.size) % 2 == 1) {
                    value1.toDouble();
                } else {
                    var next = value2
                    if (index1 < withMedian.size - 1 && withMedian[index1 + 1] < next) {
                        next = withMedian[index1 + 1]
                    }
                    (value1 + next).toDouble() / 2;
                }
            } else {
                if (value1 <= value2) {
                    low = index1 + 1
                } else {
                    high = index1 - 1
                }
            }
        }
        return null
    }
}
