package linkedlist;

/**
 * Given the head of a linked list and a value x, partition it such that
 * all nodes less than x come before nodes greater than or equal to x.
 */

public class PartitionList {
    public static Node partition(Node head, int x) {
        if (head == null)
            return head;

        Node curr = head, prev = null;
        while (curr != null && curr.val >= x) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null)
            return head;

        if (prev != null) {
            prev.next = curr.next;
            curr.next = head;
            head = curr;
        }

        Node part = head;
        curr = head.next;
        prev = head;

        while (curr != null) {
            if (curr.val >= x) {
                prev = curr;
                curr = curr.next;
            } 
            else if(part.next == curr){
                prev = curr;
                curr = curr.next;
                part = prev;
            }
            else {
                prev.next = curr.next;
                curr.next = part.next;
                part.next = curr;
                part = part.next;
                curr = prev.next;
            }
        }

        return head;

    }

    public static void main(String[] args) {
        Node list = Node.LList(new int[] { 1, 4, 3, 2, 5, 2 });
        // Node list = Node.LList(new int[] { 2, 1 });
        // Node list = Node.LList(new int[] { 1, 2, 3, 2, 4, 5, 6, 7, 8 });
        // Node list = Node.LList(new int[] { 4, 1, 3 });
        System.out.println(partition(list, 3));
    }

}
