class Solution {
    static int matrixMultiplication(int arr[]) {
       
       int n = arr.length;
    //   return recursion(arr, 1, n - 1);
       
       //MEMOIZATION
       int[][] dp = new int[n + 2][n + 1];
    //   return memoRecursion(dp, arr, 1, n - 1);
    
        return tabulation(dp, arr, n);
    }
    
    public static int tabulation(int[][] dp, int[] arr, int n) {
        for(int i = n - 1; i >= 1; i--) {
            for(int j = i + 1; j < n; j++) {
                if(i == j) continue;
                int min = Integer.MAX_VALUE;
                for(int k = i;  k < j; k++) {
                    int steps = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
                    min = Math.min(steps, min);
                }
                dp[i][j] = min;
            }
        }
        
        return dp[1][n - 1];
    }
    
    public static int memoRecursion(int[][] dp, int[] arr, int i, int j) {
        //base case
        if(i == j) return 0;
        
        if(dp[i][j] != 0) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        for(int k = i;  k < j; k++) {
            int steps = (arr[i - 1] * arr[k] * arr[j]) + recursion(arr, i , k) + recursion(arr, k + 1 , j);
            min = Math.min(steps, min);
        }
        
        return dp[i][j] = min;
    }
    
    public static int recursion(int[] arr, int i, int j) {
        //base case
        if(i == j) return 0;
        
        int min = Integer.MAX_VALUE;
        for(int k = i;  k < j; k++) {
            int steps = (arr[i - 1] * arr[k] * arr[j]) + recursion(arr, i , k) + recursion(arr, k + 1 , j);
            min = Math.min(steps, min);
        }
        
        return min;
    }
}