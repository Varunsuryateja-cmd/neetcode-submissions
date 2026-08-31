class Solution:
    def getConcatenation(self,arr):
        n=len(arr)
        nums=2*n
        ans=[0]*nums
        for i in range(len(arr)):
            ans[i]=arr[i]
            ans[i+n]=arr[i]
        return ans
