package linkedlist;

public class Reverse {
    public static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public static void main(String[] args) {
        Node lst = Node.LList(new int[]{1,2,3,4,5});
        lst = reverse(lst);
        System.out.println(lst);
    }
}
