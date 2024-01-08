package linkedlist;

public class MergeSortedLists {
    public static Node merge(Node l1, Node l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        Node curr = new Node(0);
        Node head = curr;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        while (l1 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }
        while (l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Node list1 = Node.LList(new int[] { 1, 3, 4, 6 });
        Node list2 = Node.LList(new int[] { 1, 5, 7, 8 });

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(merge(list1, list2));

    }
}
