class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int target = n;
        
        //bruteForce Approach
        // return recursion(price, n - 1, target);
        
        //Better Approach
        //MEMOIZATION
        int[][] dp = new int[n + 1][1001];
        //  return memoRecursion(price, n - 1, target, dp);
        
        //Optimal Approach
        return tabulation(price, n, target, dp);
    }
    
    public int tabulation(int[] price, int n, int target, int[][] dp) {
        //base case
        for(int t = 0; t <= target; t++) {
              int ans = t * price[0];
              dp[0][t] = ans;
        } 
        
        for(int i = 1; i < n; i++) {
            for(int t = 0; t <= target; t++) {
                int take = Integer.MIN_VALUE;
                if((i + 1) <= t) take = price[i] + dp[i][t - (i + 1)];
                int notTake = dp[i - 1][t];
                
                dp[i][t] = Math.max(take, notTake);
            } 
        }
        
        return dp[n - 1][target];
    }
    
    public int memoRecursion(int[] price, int index, int target, int[][] dp) {
        //base case
        if(index == 0) {
              int ans = target * price[0];
              return ans;  
            
        }
        
        if(dp[index][target] != 0) return dp[index][target];
        
        int take = Integer.MIN_VALUE;
        if((index + 1) <= target) take = price[index] + recursion(price, index, target - (index + 1));
        int notTake = recursion(price, index - 1, target);
        
        return dp[index][target] = Math.max(take, notTake);
    }
    
    public int recursion(int[] price, int index, int target) {
        //base case
        if(index == 0) {
            if(target % (index + 1) == 0) {
              int ans = target/(index + 1);
              ans = ans * price[0];
              return ans;  
            }
            return Integer.MIN_VALUE;
            
        }
        
        int take = Integer.MIN_VALUE;
        if((index + 1) <= target) take = price[index] + recursion(price, index, target - (index + 1));
        int notTake = recursion(price, index - 1, target);
        
        return Math.max(take, notTake);
    }
}