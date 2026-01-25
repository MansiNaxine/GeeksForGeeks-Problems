// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int floor = -1;
        
        Arrays.sort(arr);
        
        //to calculate floor
        while(start <= end) {
            
            int mid = (start + end)/2;
            
            if(arr[mid] <= x) {
                
                floor = arr[mid];
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        //To Calculate Ceil
        start = 0;
        end = n - 1;
        int ceil = -1;
        
        while(start <= end) {
            
            int mid = (start + end)/2;
            
            if(arr[mid] >= x) {
                
                ceil = arr[mid];
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return new int[]{floor, ceil};
        
    }
}
