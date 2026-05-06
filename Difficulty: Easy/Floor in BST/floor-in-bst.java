/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int ans = -1;
    public int findMaxFork(Node root, int k) {
        
        if( root == null) return ans;
        if(root.data <= k) {
            ans = root.data;
            return findMaxFork(root.right, k);
        }
        else return findMaxFork(root.left, k);
       
    }
}