/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class Solution {
    public int getCount(Node head) {
    
    int len = 0;
    Node temp = head;
    
        while(temp != null) {
            len += 1;
            temp = temp.next;
        }
        
    return len;
    }
}