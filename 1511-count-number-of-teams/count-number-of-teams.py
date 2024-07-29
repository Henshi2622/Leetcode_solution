class Solution:
    def numTeams(self, rating):
        n = len(rating)
        count = 0
        
        for j in range(1, n-1):
            count_less_before = 0
            count_more_before = 0
            count_less_after = 0
            count_more_after = 0
            
            for i in range(j):
                if rating[i] < rating[j]:
                    count_less_before += 1
                elif rating[i] > rating[j]:
                    count_more_before += 1
            
            for k in range(j+1, n):
                if rating[k] < rating[j]:
                    count_less_after += 1
                elif rating[k] > rating[j]:
                    count_more_after += 1
            
            count += count_less_before * count_more_after + count_more_before * count_less_after
        
        return count