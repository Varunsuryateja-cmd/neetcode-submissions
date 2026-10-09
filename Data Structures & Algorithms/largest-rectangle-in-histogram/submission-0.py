class Solution:
    def largestRectangleArea(self, heights: list[int]) -> int:
        max_area = 0
        stack = []  # Stores pairs: (start_index, height)

        for i, h in enumerate(heights):
            start = i
            # Pop elements from stack if the current height is smaller
            while stack and stack[-1][1] > h:
                index, height = stack.pop()
                max_area = max(max_area, height * (i - index))
                start = index  # Extend the start index for the current bar backward
            
            stack.append((start, h))

        # Process any remaining bars in the stack extending to the end of the histogram
        for i, h in stack:
            max_area = max(max_area, h * (len(heights) - i))

        return max_area