class Solution {
    public int longCommSubstr(String s1, String s2) {
        
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        return tabulation(s1, s2, n, m, dp);
    }
    
    public int tabulation(String s1, String s2, int n, int m, int[][] dp) {
        //base case
        //i == 0
        for(int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        
        //j == 0
        for(int i =0 ; i <= n; i++) {
            dp[i][0] = 0;
        }
        
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                }
                    
            }
        }
        
        return ans;
    }
}