/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        
        //Edge case
        if(head == null) return null;
        while(head.data == x) head = head.next;
        head.prev = null;
        Node temp = head;
        
        
        while(temp != null) {
            
            if(temp.data == x) {
               Node prevNode = temp.prev;
               while(temp != null && temp.data == x) {
                   temp = temp.next;
               }
               
               if (temp != null) {
                   prevNode.next = temp;
                   temp.prev = prevNode;
               } else {
                   prevNode.next = null;
               }
            } 
            
            if(temp != null) temp = temp.next;
            
        }
        return head;
        
    }
}