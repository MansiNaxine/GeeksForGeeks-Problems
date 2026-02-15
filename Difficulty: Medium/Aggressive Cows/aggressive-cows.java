class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        
        Arrays.sort(stalls);
        int n = stalls.length;
        int start = 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int stall : stalls) {
            max = Math.max(stall, max);
            min = Math.min(stall, min);
        }
        
        int end = max - min;
        int ans = 1;
        
        while(start <= end) {
            
            int mid = (start + end)/2;  
            int possibleCows = getPossibleCowsNo(stalls, mid);
            
            if(possibleCows >= k) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        return ans;
        
    }
    
    public int getPossibleCowsNo(int[] stalls, int mid) {
        
        int i = 0; 
        int j = 1;
        int cows = 1;
        int n = stalls.length;
        
        while(j < n) {
            if((stalls[j] - stalls[i] )>= mid) {
                cows += 1;
                i = j;
            }
            j++;
        }
        
        return cows;
        
    }
}