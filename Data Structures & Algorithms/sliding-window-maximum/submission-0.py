from collections import deque
from typing import List

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        q = deque()  # stores indices of elements in decreasing order of values
        
        for l in range(len(nums)):
            # Remove indices that are out of the current window bounds
            if q and q[0] < l - k + 1:
                q.popleft()
                
            # Maintain monotonic decreasing order:
            # remove smaller elements from the back as they won't be max
            while q and nums[q[-1]] <= nums[l]:
                q.pop()
                
            q.append(l)
            
            # Append max element to result once the first full window is formed
            if l >= k - 1:
                res.append(nums[q[0]])
                
        return res