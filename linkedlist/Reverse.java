package linkedlist;

public class Reverse {
    public static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static Node recursion(Node root) {
        if(root == null) return null;
        if(root.next == null) return root;

        Node righthead = recursion(root.next);

        root.next.next = root;
        root.next = null;

        return righthead;
    }

    public static void main(String[] args) {
        Node lst = Node.LList(new int[] { 1, 2, 3, 4, 5 });
        lst = reverse(lst);
        lst = recursion(lst);
        System.out.println(lst);
    }
}
