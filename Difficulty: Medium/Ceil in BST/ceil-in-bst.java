/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int ans = -1;
    int findCeil(Node root, int x) {
        
        if(root == null) return ans;
        else if(root.data >= x) {
            ans = root.data;
            return findCeil(root.left, x);
        }
        
        return findCeil(root.right, x);
    }
}