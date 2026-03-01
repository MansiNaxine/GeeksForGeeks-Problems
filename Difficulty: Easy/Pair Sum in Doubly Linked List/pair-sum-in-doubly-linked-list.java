/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        //Code here
        //First we have to find the tail and apply the two pointers concept
        Node tail = getTail(head);
        Node temp = head;
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        
        while( temp != null && tail != null && temp.data < tail.data) {
        
            if((temp.data + tail.data) == target) {
                ArrayList<Integer> curr = new ArrayList<>();
                curr.add(temp.data);
                curr.add(tail.data);
                
                answer.add(new ArrayList<>(curr));
                
                temp = temp.next;
                tail = tail.prev;
            }
            else if ((temp.data + tail.data) < target) {
                temp = temp.next;
            }
            else {
                tail = tail.prev;
            }
        }
        
        return answer;
        
    }
    
    public static Node getTail(Node head) {
        
        Node temp = head;
        Node prevNode = null;
        
        while(temp != null) {
            prevNode = temp;
            temp = temp.next;
        }
        
        return prevNode;
    }
}
