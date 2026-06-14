class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
       
       int n = arr.length;
       
       //BruteForce Approach
       //return bruteForceApprach(arr, sum, n -1);
       
       //Optimal Soultion
       //MEMOIZATION
       int sizeSum = 10000;
       boolean[][] dp = new boolean[n][sizeSum + 1];
    //   return memoRecursion(arr, sum, n - 1, dp);
    
        //OPTIMAL SOLUTOIN
        // TABULATION
        return tabulation(arr, sum, n, dp);
    }
    
    public static boolean tabulation(int[] arr, int sum, int n, boolean[][] dp) {
        //base cases
        for(int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        
        dp[0][arr[0]] = true;
        
        //express all states in loops
        for(int i = 1; i < n; i++) {
            for(int target = 1; target <= sum; target++) {
                boolean take = false;
                if(arr[i] <= target) take = dp[i - 1][target - arr[i]];
                boolean notTake = dp[i- 1][target];
                
                dp[i][target] = take || notTake; 
            }
        }
        
        return dp[n - 1][sum];
    }
    
    public static boolean memoRecursion(int[] arr, int sum, int index, boolean[][] dp) {
        //base cases
        if(sum == 0) return true;
        if(index == 0) return arr[0] == sum;
        
        if(dp[index][sum]) return true;
        else {
            boolean take = false;
            if(arr[index] <= sum) take = memoRecursion(arr, sum - arr[index], index - 1, dp);
            boolean notTake = memoRecursion(arr, sum, index- 1, dp);
            
            return dp[index][sum] = take || notTake; 
        }
        
    }
    
    public static boolean bruteForceApprach(int[] arr, int sum, int index) {
        //base cases
        if(sum == 0) return true;
        if(index == 0) return arr[index] == sum;
        
        //recursive case
        boolean take = false;
        if(arr[index] <= sum) take = bruteForceApprach(arr, sum - arr[index], index - 1);
        boolean notTake = bruteForceApprach(arr, sum, index - 1);
        
        return take || notTake;
    }
}