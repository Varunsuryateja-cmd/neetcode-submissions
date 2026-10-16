class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # Ensure nums1 is the smaller array to minimize binary search range
        A, B = nums1, nums2
        if len(A) > len(B):
            A, B = B, A
            
        total = len(A) + len(B)
        half = total // 2
        
        l, r = 0, len(A) - 1
        while True:
            # i is the middle index for partition in A
            i = l + (r - l) // 2
            # j is the corresponding index for partition in B
            j = half - i - 2
            
            Aleft = A[i] if i >= 0 else float("-inf")
            Aright = A[i + 1] if (i + 1) < len(A) else float("inf")
            Bleft = B[j] if j >= 0 else float("-inf")
            Bright = B[j + 1] if (j + 1) < len(B) else float("inf")
            
            # Check if partition is correct
            if Aleft <= Bright and Bleft <= Aright:
                # Odd number of total elements
                if total % 2 != 0:
                    return min(Aright, Bright)
                # Even number of total elements
                return (max(Aleft, Bleft) + min(Aright, Bright)) / 2.0
            elif Aleft > Bright:
                r = i - 1
            else:
                l = i + 1