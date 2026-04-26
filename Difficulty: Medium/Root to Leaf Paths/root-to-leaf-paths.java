/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
       
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        recursion(root, answer, curr);
        return answer;
    }
    
    public static void recursion(Node root, ArrayList<ArrayList<Integer>> answer, ArrayList<Integer> curr) {
        //basec case
        if(root == null) {
            return;
        }
        
        
        
        //recursive case
        curr.add(root.data);
        recursion(root.left, answer, curr);
        if(root.left == null && root.right == null) {
            answer.add(new ArrayList<>(curr));
            return;
        }
        else {
            while(curr.get(curr.size() - 1) != root.data) {
                curr.removeLast();
            }
            recursion(root.right, answer, curr);
        }
        
    }
}