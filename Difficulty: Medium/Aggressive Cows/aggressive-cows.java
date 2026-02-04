class Solution {
    public int aggressiveCows(int[] stalls, int k) {
       
       int n = stalls.length;
       Arrays.sort(stalls);
       int start = 1;
       int dist = 0;
       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;
       
       for(int num : stalls) {
           min = Math.min(num, min);
           max = Math.max(num, max);
       }
       
       dist = max - min;
       int end = dist;
       int ans = start;
       
       while(start <= end) {
           
           int mid = (start + end) /2;
           int possibleNoOfCows = getNoOfCows(stalls, mid);
           if (possibleNoOfCows >= k) {
               ans = mid;
               start = mid + 1;
           }
           else {
               end = mid - 1;
           }
       }
       
       return ans;
        
    }
    
    public int getNoOfCows(int[] stalls, int mid) {
        
        int cows = 1;
        int cowPlaced = 0;
        for(int i = 1; i < stalls.length; i++) {
            if((stalls[i] - stalls[cowPlaced]) >= mid) {
                cowPlaced = i;
                cows += 1;
            }
        }
        
        return cows;
    }
}