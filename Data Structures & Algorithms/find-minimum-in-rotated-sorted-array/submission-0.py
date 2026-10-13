class Solution:
    def findMin(self, nums: List[int]) -> int:
        res = nums[0]
        l, r = 0, len(nums) - 1

        while l <= r:
            # If the current subsegment is already sorted, 
            # the minimum is the leftmost element.
            if nums[l] < nums[r]:
                res = min(res, nums[l])
                break

            mid = (l + r) // 2
            res = min(res, nums[mid])

            # Decide whether to search the left or right half
            if nums[mid] >= nums[l]:
                # Left side is sorted, so the minimum must be in the right half
                l = mid + 1
            else:
                # Right side is sorted, so the minimum must be in the left half
                r = mid - 1

        return res