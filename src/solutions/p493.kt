package solutions

// https://leetcode.com/problems/reverse-pairs/
class p493 {
    fun reversePairs(nums: IntArray): Int {
        return reversePairs(nums, 0, nums.size)
    }

    private fun reversePairs(nums: IntArray, left: Int, right: Int): Int {
        if (right - left <= 1) {
            return 0
        }
        val middle = (right + left) / 2
        var result = reversePairs(nums, left, middle) + reversePairs(nums, middle, right)

        var li = left
        var ri = middle

        while (li < middle && ri < right) {
            while (li < middle && nums[li] <= 2.toLong() * nums[ri]) {
                li++
            }
            result += middle - li
            ri++
        }

        li = left
        ri = middle
        val tmp = IntArray(right - left)
        var idx = 0

        while (li < middle || ri < right) {
            if (li == middle) {
                tmp[idx] = nums[ri]
                ri++
            } else if (ri == right){
                tmp[idx] = nums[li]
                li++
            } else {
                if (nums[li] < nums[ri]) {
                    tmp[idx] = nums[li]
                    li++
                } else {
                    tmp[idx] = nums[ri]
                    ri++
                }
            }
            idx++
        }
        for (i in left until right) {
            nums[i] = tmp[i - left]
        }

        return result
    }
}
