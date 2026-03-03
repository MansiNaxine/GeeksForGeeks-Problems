// Node class
/* class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
} */

// Stack class

class myStack {
    Node head;
    Node temp;
    Node prev;
    int top;
    int size;

    public myStack() {
        head = new Node(-1);
        temp = head;
        prev = null;
        top = -1;
        size = 0;
    }

    public void push(int x) {
        Node curr = new Node(x);
        temp.next = curr;
        prev = temp;
        temp = curr;
        top = temp.data;
        size += 1;
    }

    public int pop() {
        temp = head;
        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }

        Node nextNode = temp;
        temp = prev;
        temp.next = null;
        top = temp.data;
        size -= 1;


        return nextNode.data;
    }

    public int peek() {
        return top;
    }

    public boolean isEmpty() {

        return head.next == null;
    }
    
    public int size() {
        return size;
    }
}

