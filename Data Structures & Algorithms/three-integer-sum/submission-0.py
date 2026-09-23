class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        nums.sort()
        res = []
        
        for i in range(len(nums)):
            # Skip positive numbers as outer loop value because sum of three positive numbers can't be 0
            if nums[i] > 0:
                break
                
            # Skip duplicate outer loop elements to avoid duplicate triplets
            if i > 0 and nums[i] == nums[i - 1]:
                continue
                
            l, r = i + 1, len(nums) - 1
            while l < r:
                three_sum = nums[i] + nums[l] + nums[r]
                
                if three_sum > 0:
                    r -= 1
                elif three_sum < 0:
                    l += 1
                else:
                    res.append([nums[i], nums[l], nums[r]])
                    l += 1
                    r -= 1
                    
                    # Skip duplicate inner loop elements
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1
                        
        return res