// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        
        Arrays.sort(arr);
        
        int ans[] = new int[2];
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int ceil = -1;
        int floor = -1;
        
        //To find Ceil 
        while(start <= end) {
            
            int mid = (start + end)/2;
            
            if (arr[mid] >= x) {
                ceil = arr[mid];
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        start = 0;
        end = n - 1;
        //To Find floor
        while(start <= end) {
            
            int mid = (start + end)/2;
            
            if (arr[mid] <= x) {
                floor = arr[mid];
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        ans[0] = floor;
        ans[1] = ceil;
        
        return ans;
    }
}
