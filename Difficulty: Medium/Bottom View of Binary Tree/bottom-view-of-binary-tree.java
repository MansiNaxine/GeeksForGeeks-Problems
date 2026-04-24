/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        Queue<Pair> que = new LinkedList<>();
        Pair p =new Pair();
        p.node = root;
        p.cnt = 0;
        que.add(p);
        Map<Integer, Integer> map = new TreeMap<>();
        
        while(!que.isEmpty()) {
            int size = que.size();
            
            for(int i = 0; i < size; i++) {
                Pair pNew = que.peek();
                Node newNode = pNew.node;
                int count = pNew.cnt;
                que.remove();
                
                if(!map.containsKey(count)) {
                    map.put(count, newNode.data);
                }
                else {
                    map.put(count, newNode.data);
                }
                
                if(newNode.left != null) {
                    Pair innerP = new Pair();
                    innerP.node = newNode.left;
                    innerP.cnt = count - 1;
                    que.add(innerP);
                }
                
                if(newNode.right != null) {
                    Pair innerP = new Pair();
                    innerP.node = newNode.right;
                    innerP.cnt = count + 1;
                    que.add(innerP);
                }
                
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        
        return result;
        
    }
}

class Pair {
    Node node;
    int cnt;

    Pair() {
        this.node = null;
        cnt = 0;
    }

}