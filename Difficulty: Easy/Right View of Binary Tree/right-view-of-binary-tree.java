/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> rightView(Node root) {
        
        Map<Integer, Integer> map  = new TreeMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        recursion(root, map, 0);
        
        for(int entry : map.keySet()) {
            answer.add(map.get(entry));
        }
        
        return answer;
        
    }
    
    public void recursion(Node root, Map<Integer, Integer> map, int height) {
        if(root == null) return;
        
        if(!map.containsKey(height)) {
            map.put(height, root.data);
        }
        
        recursion(root.right, map, height + 1);
        recursion(root.left, map, height + 1);
    } 
}