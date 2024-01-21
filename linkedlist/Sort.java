package linkedlist;

public class Sort {
    // merge sort;
    public static Node merge(Node root1, Node root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        Node res = new Node(0);
        Node head = res;

        while (true) {
            if (root1.val <= root2.val) {
                res.next = root1;
                root1 = root1.next;
            } else {
                res.next = root2;
                root2 = root2.next;
            }
            res = res.next;
            if (root1 == null) {
                res.next = root2;
                break;
            }
            if (root2 == null) {
                res.next = root1;
                break;
            }

        }
        return head.next;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node right = mergeSort(slow.next);
        slow.next = null;
        Node left = mergeSort(head);
        return merge(left, right);
    }

    public static void main(String[] args) {
        Node list = Node.LList(new int[] {
                4, 2, 1, 3
        });

        System.out.println(mergeSort(list));

    }
}
