class Solution {
    public int minTime(int[] arr, int k) {
        
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int num : arr) {
            sum += num;
            max = Math.max(max, num);
        }
        
        int start = max;
        int end = sum;
        int ans = max;
        
        //Edge Cases
        if(k == 1) return sum;
        else if (k == n) return max;
        
        while(start <= end) {
            
            int mid = (start + end)/2;
            int possiblePainters = getPossiblePainters(mid, arr);
            
            if(possiblePainters <= k) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return ans;
        
    }
    
    public int getPossiblePainters(int mid, int[] arr) {
        
        int cnt = 0;
        int sum = 0;
        
        for(int num : arr) {
            
            if((sum + num) <= mid) {
                sum += num;
            }
            else {
                cnt += 1;
                sum = num;
            }
        }
        
        return cnt + 1;
    }
}
