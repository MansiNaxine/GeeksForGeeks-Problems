/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        
        Node newHead = reverseList(head);
        Node temp = newHead;
        int carry = 1;
        int sum = 0;
        
        while(temp != null) {
            sum = temp.data + carry;
            temp.data = sum%10;
            carry = sum/10;
            if(temp.next == null) break;
            temp = temp.next;
        }
        
        if(carry > 0) {
            Node currNode = new Node(carry);
            temp.next = currNode;
        }
        
        Node resultHead = reverseList(newHead);
        return resultHead;
        
    }
    
    public Node reverseList(Node head) {

        Node temp = head;
        Node prev = null;
        Node nextNode = null;

        while(temp != null) {
            nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        return prev;
    }
}