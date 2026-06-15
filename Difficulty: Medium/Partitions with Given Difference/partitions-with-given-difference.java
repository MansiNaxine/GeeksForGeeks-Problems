class Solution {
    public int countPartitions(int[] arr, int diff) {
       
       int n = arr.length;
       //Calculate target;
       int totalSum = 0;
       for(int num : arr) totalSum += num;
       int target = totalSum - diff;
       if(target%2 == 1 || target < 0) return 0;
       else target = target/2;
       
       //bruteForce Approach;
    //   return recursion(arr, n - 1, target);
       
       //memoization
       int[][] dp = new int[n][totalSum + 1];
    //   return memoRecursion(arr, n - 1, target, dp);
    
        //TABULATION
        return tabulation(arr, n, target, dp);
       
    }
    
    public int tabulation(int[] arr, int n, int target, int[][] dp) {
        
        if(arr[0] == 0) dp[0][0] = 2;
        else {
            dp[0][0] = 1;
            dp[0][arr[0]] = 1;
        }
        
        for(int i = 1; i < n; i++) {
            for(int t = 0; t <= target; t++) {
                int take= 0;
                if(arr[i] <= t) take = dp[i - 1][t - arr[i]];
                int notTake = dp[i - 1][t];
                
                dp[i][t] = take + notTake;
            }
        }
        
        return dp[n - 1][target];
    }
    
    public int memoRecursion(int[] arr, int index, int target, int[][] dp) {
        if(index == 0) {
            if(arr[0] == target && arr[0] == 0) return 2;
            if(arr[0] == target || target == 0) return 1;
            return 0;
        }
        
        if(dp[index][target] != 0) return dp[index][target];
        //recursive case
        int take= 0;
        if(arr[index] <= target) take = recursion(arr, index - 1, target - arr[index]);
        int notTake = recursion(arr, index - 1, target);
        
        return dp[index][target] = take + notTake;
    }
    
    public int recursion(int[] arr, int index, int target) {
        //base cases
        if(index == 0) {
            if(arr[0] == target && arr[0] == 0) return 2;
            if(arr[0] == target || target == 0) return 1;
            return 0;
        }
        
        //recursive case
        int take= 0;
        if(arr[index] <= target) take = recursion(arr, index - 1, target - arr[index]);
        int notTake = recursion(arr, index - 1, target);
        
        return take + notTake;
    }
}
