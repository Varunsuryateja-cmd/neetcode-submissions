class Solution:
    def replaceElements(self,arr):
        maxright=0
        for i in range(len(arr)-1,-1,-1):
            curr=arr[i]
            arr[i]=maxright
            maxright=max(maxright,curr)
        arr[-1]=-1
        return arr