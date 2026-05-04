// User function Template for Java

class Solution {

    public static boolean isPossible(int a, int b) {
        // Code here
        return ((a == 1 && b == 2) || (a == 2 && b == 1) || (a == 2 && b == 3) || (a == 3 && b == 2)) ? true : false;
        
    }
}