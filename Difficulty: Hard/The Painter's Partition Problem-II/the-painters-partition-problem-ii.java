class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int num : arr) {
            max = Math.max(max, num);
            sum += num;
        }
        
        //Edge case
        if(n == k) return max;
        
        int start = max;
        int end = sum;
        int ans = -1;
        
        while(start <= end) {
            
            int mid = (start + end)/2;
            int possiblePainters = getNoOfPainters(arr, mid);
            
            if (possiblePainters <= k) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            
        }
        
        return ans;
        
    }
    
    public int getNoOfPainters(int[] arr, int mid) {
        
        int sum = 0;
        int count = 1;
        
        for(int num : arr) {
            if ((sum + num) <= mid) {
                sum += num;
            }
            else {
                count += 1;
                sum = num;
            }
        }
        
        return count;
        
    }
}
