class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        
        int n = nums.length;
        //BruteForce Approach
        // return recursion(nums, target, n - 1);
        
        int targetSize = 1000;
        //optimal Solution
        //MEMOIZATION
        int[][] dp = new int[n][targetSize + 1];
        // return memoRecursion(nums, target, n - 1, dp);
        
        //more optimal solution
        //TABULATION
        return tabulation(nums, target, n, dp);  
    }
    
    public int tabulation(int[] nums, int target, int n, int[][] dp) {
        //base cases
        if(nums[0] == 0) dp[0][0] = 2;
        else {
            dp[0][0] = 1;
            dp[0][nums[0]] = 1;
        }
        
        for(int i = 1; i < n; i++) {
            for(int t = 0; t <= target; t++) {
                
                int take = (nums[i] <= t) ? dp[i- 1][t - nums[i]] : 0;
                int notTake = dp[i - 1][t];
                
                dp[i][t] = take + notTake;
            }
        }
        
        
        return dp[n - 1][target];
    }
    
    public int memoRecursion(int[] nums, int target, int index, int[][] dp) {
        //base case
        if(index == 0) {
            if(nums[0] == target && target == 0) return 2;
            else if(nums[0] == target || target == 0) return 1;
            return 0;
        }
        
        //recursive case
        if(dp[index][target] != 0) return dp[index][target];
        
        int take = (nums[index] <= target) ? recursion(nums, target - nums[index], index - 1) : 0;
        int notTake = recursion(nums, target, index - 1);
        
        return dp[index][target] = take + notTake;
        
    }
    
    public int recursion(int[] nums, int target, int index) {
        
        if(index == 0) {
            if(nums[0] == target && target == 0) return 2;
            else if (nums[0] == target || target == 0) return 1;
            return 0;
        }
        
        //recursive case
        int take = (nums[index] <= target) ? recursion(nums, target - nums[index], index - 1) : 0;
        int notTake = recursion(nums, target, index - 1);
        
        return take + notTake;
     }
}