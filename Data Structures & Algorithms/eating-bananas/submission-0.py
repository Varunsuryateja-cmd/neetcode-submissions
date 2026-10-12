import math
from typing import List

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 1, max(piles)
        res = right

        while left <= right:
            k = (left + right) // 2
            
            # Calculate hours needed at eating rate k
            hours = 0
            for p in piles:
                hours += math.ceil(p / k)
            
            if hours <= h:
                res = k
                right = k - 1  # Try to find a smaller valid k
            else:
                left = k + 1   # Too slow, increase k
                
        return res