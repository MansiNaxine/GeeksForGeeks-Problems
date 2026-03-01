/*
class Node{
    int data;
    Node next, prev;
    Node(int x){
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        // Code Here.
         Node temp = head;
         Node prevNode = head;
         Node nextNode = head;
         Node dummyNode = new Node(-1);
         Node res = dummyNode;
         
         while(temp != null) {
             nextNode = temp.next;
             prevNode = temp;
             
             while(nextNode != null && prevNode.data == nextNode.data) {
                 nextNode = nextNode.next;
             }
             
            //  if(nextNode != null) {
                temp.next =  nextNode;
                res.next = temp;
                res = temp;
                temp = nextNode;
            if(temp != null) temp.prev = prevNode;
            //  }
         }
         
         return dummyNode.next;
    }
}   