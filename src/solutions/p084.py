from typing import List

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        return self.with_sides(heights)

    def with_stacks(self, heights: List[int]) -> int:
        stack = []
        result = 0
        for i, height in enumerate(heights + [0]):
            start_this_height = i
            while stack and stack[-1][0] > height:
                top = stack.pop()
                cur_area = top[0] * (i - top[1])
                result = max(result, cur_area)
                start_this_height = top[1]
            stack.append((height, start_this_height))
        return result

    def with_sides(self, heights: List[int]) -> int:
        to_the_left = self.first_shorter_to_the_left(heights)
        to_the_right = self.first_shorter_to_the_left(heights[::-1])
        result = 0
        for i, height in enumerate(heights):
            tl = to_the_left[i]
            tr = len(heights) - to_the_right[-i - 1] - 1
            #print(f'{i} {height} {tl} {tr} {height * (tr - tl - 1)}')
            result = max(result, height * (tr - tl - 1))
        return result

    def first_shorter_to_the_left(self, heights: List[int]) -> int:
        result = []
        for i, height in enumerate(heights):
            if i == 0:
                result.append(-1)
                continue
            cur = i - 1
            while cur >= 0 and heights[cur] >= height:
                cur = result[cur]
            result.append(cur)
        return result

assert Solution().largestRectangleArea([2, 1, 5, 6, 2, 3]) == 10
assert Solution().largestRectangleArea([1, 2, 3, 2, 1]) == 6
assert Solution().largestRectangleArea([1, 1, 1, 1]) == 4
assert Solution().largestRectangleArea([3, 3, 2, 3]) == 8
assert Solution().largestRectangleArea([]) == 0
