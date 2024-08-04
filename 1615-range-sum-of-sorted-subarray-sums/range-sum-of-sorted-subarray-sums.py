class Solution(object):
    def rangeSum(self, nums, n, left, right):
        sub=[]
        mod=10**9+7
        for i in range(n):
            curr_sum=0
            for j in range(i,n):
                curr_sum=(curr_sum+nums[j])%mod
                sub.append(curr_sum)
        sub.sort()
        res=0
        for i in range(left-1,right):
            res=(res+sub[i])%mod
        return res

