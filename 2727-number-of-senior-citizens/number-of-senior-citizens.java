class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(String i:details){
            char tens=i.charAt(11);
            char ones =i.charAt(12);
            if(tens>'6'||(tens=='6'&& ones >'0')){
                count++;
            }
        }

        return count;
    }
}