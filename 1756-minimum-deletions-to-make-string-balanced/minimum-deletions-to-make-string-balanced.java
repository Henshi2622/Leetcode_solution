class Solution {
    public int minimumDeletions(String s) {

        int bCount = 0; // Count of 'b' characters encountered
        int minDeletions = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++; // Increment count of 'b' characters
            } else { // c == 'a'
                minDeletions = Math.min(minDeletions + 1, bCount); // Either delete current 'a' or previous 'b's
            }
        }

        return minDeletions;
        
    }
    
}