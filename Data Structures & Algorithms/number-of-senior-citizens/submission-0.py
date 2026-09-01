class Solution:
    def countSeniors(self,details):
        count=0
        
        for i in range(len(details)):
            h=int(details[i][11:13])
            
            if h>60:
                count+=1
        return count