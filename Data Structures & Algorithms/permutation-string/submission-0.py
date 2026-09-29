class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n1, n2 = len(s1), len(s2)
        
        # If s1 is longer than s2, s2 cannot contain a permutation of s1
        if n1 > n2:
            return False
        
        s1_counts = [0] * 26
        s2_counts = [0] * 26
        
        # Build frequency counts for s1 and the first window of s2
        for i in range(n1):
            s1_counts[ord(s1[i]) - ord('a')] += 1
            s2_counts[ord(s2[i]) - ord('a')] += 1
            
        # Track character frequency matches between s1 and current window in s2
        matches = sum(1 for i in range(26) if s1_counts[i] == s2_counts[i])
        
        # Slide the window of length len(s1) across s2
        for l in range(n2 - n1):
            if matches == 26:
                return True
            
            # Character entering the window on the right
            r_idx = ord(s2[l + n1]) - ord('a')
            s2_counts[r_idx] += 1
            if s1_counts[r_idx] == s2_counts[r_idx]:
                matches += 1
            elif s1_counts[r_idx] + 1 == s2_counts[r_idx]:
                matches -= 1
                
            # Character leaving the window on the left
            l_idx = ord(s2[l]) - ord('a')
            s2_counts[l_idx] -= 1
            if s1_counts[l_idx] == s2_counts[l_idx]:
                matches += 1
            elif s1_counts[l_idx] - 1 == s2_counts[l_idx]:
                matches -= 1
                
        return matches == 26