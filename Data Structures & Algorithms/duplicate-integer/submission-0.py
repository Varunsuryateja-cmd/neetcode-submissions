class Solution:
    def hasDuplicate(self,arr):
        s=set()
        for i in arr:
            if i in s:
                return True
            s.add(i)
        return False
        