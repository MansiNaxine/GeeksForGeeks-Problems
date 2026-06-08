class Solution {
    int minCost(int[] height) {
        
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return recursionMemo(dp, n-1, height);
    }
    
    public int recursionMemo(int[] dp, int n, int[] height) {
        //base case
        if(n == 0) return 0;
        
        if(dp[n] != -1) return dp[n];
        
        int left = recursionMemo(dp, n - 1, height) + Math.abs(height[n] - height[n - 1]);
        int right = Integer.MAX_VALUE;
        if(n > 1) right = recursionMemo(dp, n - 2, height) + Math.abs(height[n] - height[n - 2]);
        
        return dp[n] = Math.min(left, right);
        
    }
}