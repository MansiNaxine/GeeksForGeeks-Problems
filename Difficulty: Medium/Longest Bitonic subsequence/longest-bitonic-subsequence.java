class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
       
       return modifiedTabulation(nums, n);
        
    }
    
    public static int modifiedTabulation(int[] nums, int n) {
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        int maxAns = 0;
        
        //increasing order from 0th index
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(1 + dp1[j] > dp1[i] && nums[j] < nums[i]) {
                    dp1[i] = 1 + dp1[j];
                }
            }
        }
        
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        
        //increasing from nth index
        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j > i; j--) {
                if(1 + dp2[j] > dp2[i] && nums[j] < nums[i]) {
                    dp2[i] = 1 + dp2[j];
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(dp1[i] > 1 && dp2[i] > 1) maxAns = Math.max(maxAns, dp1[i] + dp2[i] - 1);
        }
        
        return maxAns;
    }
}
