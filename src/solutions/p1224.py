from typing import List

class Solution:
    def maxEqualFreq(self, nums: List[int]) -> int:
        val_to_occ = {}
        occ_to_vals = {}
        best = 0
        max_occ = 0
        distinct = set()

        for i, num in enumerate(nums):
            distinct.add(num)
            prev_occ = val_to_occ.get(num, 0)
            val_to_occ[num] = prev_occ + 1
            if prev_occ > 0:
                occ_to_vals[prev_occ].remove(num)
            current_occ = prev_occ + 1
            vals = occ_to_vals.get(current_occ, set())
            vals.add(num)
            occ_to_vals[current_occ] = vals

            if current_occ > max_occ:
                max_occ = current_occ

            if len(distinct) == 1 or max_occ == 1:
                best = i + 1
                continue

            if len(occ_to_vals[max_occ]) == 1 and len(occ_to_vals[max_occ - 1]) == len(distinct) - 1:
                best = i + 1
                continue

            if len(occ_to_vals[max_occ]) == len(distinct) - 1 and len(occ_to_vals[1]) == 1:
                best = i + 1
                continue

        return best

solution = Solution()
assert solution.maxEqualFreq([2,2,1,1,5,3,3,5]) == 7
assert solution.maxEqualFreq([1,1,1,2,2,2,3,3,3,4,4,4,5]) == 13
assert solution.maxEqualFreq([1,1,1,2,2,2]) == 5
assert solution.maxEqualFreq([10,2,8,9,3,8,1,5,2,3,7,6]) == 8
assert solution.maxEqualFreq([1, 2]) == 2
