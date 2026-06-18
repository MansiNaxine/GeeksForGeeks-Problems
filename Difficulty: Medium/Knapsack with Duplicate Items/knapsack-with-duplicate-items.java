class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        
        int n = wt.length;
        
        //bruteForceApproach
        // return recursion(val, wt, n - 1, capacity);
        
        //Better Approach
        //MEMOIZATION
        int[][] dp = new int[n][1001];
        // return memoRecursion(val, wt, n - 1, capacity, dp);
        
        //Optimal Approach
        return tabulation(val, wt, n, capacity, dp);
    }
    
    public int tabulation(int[] val, int[] wt, int n, int capacity, int[][] dp) {
        //base case
        for(int c = 0; c <= capacity; c++) {
            int ans = c/wt[0];
            ans = ans * val[0];
            dp[0][c] = ans;
        }
        
        
        for(int i = 1; i < n; i++) {
            for(int cap = 0; cap <= capacity; cap++) {
                int take = 0;
                if(wt[i] <= cap) take = val[i] + dp[i][cap - wt[i]];
                int notTake = dp[i - 1][cap];
                
                dp[i][cap] = Math.max(take, notTake);
            }
        }
        
        return dp[n - 1][capacity];
        
    }
    
    public int memoRecursion(int[] val, int[] wt, int index, int capacity, int[][] dp) {
        //base case
        if(index == 0) {
            int ans = capacity/wt[0];
            ans = ans * val[0];
            return ans;
        }
        
        if(dp[index][capacity] != 0) return dp[index][capacity];
        
        int take = 0;
        if(wt[index] <= capacity) take = val[index] + recursion(val, wt, index, capacity - wt[index]);
        int notTake = recursion(val, wt, index - 1, capacity);
        
        return dp[index][capacity] = Math.max(take, notTake);
    }
    
    public int recursion(int[] val, int[] wt, int index, int capacity) {
        //base case
        if(index == 0) {
            int ans = capacity/wt[index];
            ans = ans * val[index];
            return ans;
        }
        
        int take = 0;
        if(wt[index] <= capacity) take = val[index] + recursion(val, wt, index, capacity - wt[index]);
        int notTake = recursion(val, wt, index - 1, capacity);
        
        return Math.max(take, notTake);
    }
}