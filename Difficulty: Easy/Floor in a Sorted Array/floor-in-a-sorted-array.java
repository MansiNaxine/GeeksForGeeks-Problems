class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int ans = -1;
        
        while(start <= end) {
            
            int mid = (start + end)/2;
            if (arr[mid] <= x) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        return ans;
    }
}
