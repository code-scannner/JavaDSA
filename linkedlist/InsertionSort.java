package linkedlist;

public class InsertionSort {
    public static Node insertionSort(Node head) {
        if (head == null)
            return head;

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.val >= prev.val) {
                prev = curr;
                curr = curr.next;
            } else if (curr.val <= head.val) {
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                curr = prev.next;
            } else {
                Node _prev = head;
                Node _curr = head.next;
                while (_curr != curr) {
                    if (_curr.val > curr.val) {
                        prev.next = curr.next;
                        _prev.next = curr;
                        curr.next = _curr;
                        curr = prev.next;
                        break;
                    } else {
                        _prev = _curr;
                        _curr = _curr.next;
                    }
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        // Node list = Node.LList(new int[] {
        // 30, 23, 28, 30, 11, 14, 19, 16, 21, 25
        // });
        Node list = Node.LList(new int[] {
                19, 20, 16, 24, 12, 29, 30
        });
        Node sorted = insertionSort(list);
        System.out.println(sorted);

    }
}
