class Solution(object):
    def kthDistinct(self, arr, k):
        str=[]
        frequency={}
        for i in arr:
            if i in frequency:
                frequency[i]+=1
            else:
                frequency[i]=1

        for j in arr:
            if frequency[j]==1:
                str.append(j)

        if len(str) >= k:
            return str[k-1]
        else:
            return ""
            

        