class Solution {
    public int maximumPoints(int mat[][]) {
            
        int n = mat.length;
        int lastTask = 3;
        //First solve it by using basic recursion
        //return basicRecursion(mat, n - 1, lastTask);
        
        //Memoization
        int[][] dp = new int[n][3];
        return memoRecursion(mat, n-1, lastTask, dp);
    }
    
    public int memoRecursion(int[][] mat, int index, int lastTask, int[][] dp) {
        //base case
        if(index == 0) {
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 3; i++) {
                if(i != lastTask) {
                    max = Math.max(max, mat[index][i]);
                }
            }
            
            return max;
        }
        
        if(lastTask < 3 && dp[index][lastTask] != 0) return dp[index][lastTask];
        //recursive case
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            if(i != lastTask) {
                
                int point = mat[index][i] + memoRecursion(mat, index - 1, i, dp);
                max = Math.max(max, point);
            }
        }
        
        if(lastTask < 3) return dp[index][lastTask] = max;
        else return max;
    }
    
    public int basicRecursion(int[][] mat, int index, int lastTask) {
        //base case
        if(index == 0) {
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 3; i++) {
                if(i != lastTask) {
                    max = Math.max(max, mat[index][i]);
                }
            }
            
            return max;
        }
        
        //recursive case
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            if(i != lastTask) {
                int point = mat[index][i] + basicRecursion(mat, index - 1, i);
                max = Math.max(max, point);
            }
        }
        
        return max;
    }
}