// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        
        Arrays.sort(bt);
        
        int n = bt.length;
        int wt = 0;
        int time = 0;
        int i = 0;
        
        while(i < n) {
            wt += time;
            time += bt[i];
            i++;
            
        }
        
        return wt/n;
    }
}
