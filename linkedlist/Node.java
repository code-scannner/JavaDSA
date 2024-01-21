package linkedlist;

public class Node {
    int val;
    Node next;

    Node(int data) {
        val = data;
        next = null;
    }

    public int size() {
        Node curr = this;
        int cnt = 0;
        while(curr != null) {
            cnt++;
            curr = curr.next;
        }

        return cnt;
    }

    public static Node LList(int[] list) {
        Node head = new Node(0);
        Node curr = head;
        for (int item : list) {
            curr.next = new Node(item);
            curr = curr.next;
        }

        return head.next;
    }

    public Node find(int target){
        Node head = this;
        while(head != null){
            if(head.val == target) return head;
            head = head.next;
        }

        return null;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append('[');
        str.append(this.val);

        Node curr = this.next;
        while (curr != null) {
            str.append(", ");
            str.append(curr.val);
            curr = curr.next;
        }
        str.append(']');
        return str.toString();
    }
}
