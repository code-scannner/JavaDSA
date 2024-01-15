package linkedlist;

public class DetectLoop {
    public static boolean hasCycle(Node root) {
        if (root == null || root.next == null)
            return false;

        Node prev = root;
        Node curr = root.next;
        while (curr != null && curr.next != null) {
            if (prev == curr)
                return true;
            prev = prev.next;
            curr = curr.next.next;
        }
        return false;

    }

    public static Node cycleBeginNode(Node head) {
        if (head == null)
            return null;
        Node slow = head, fast = head, entry = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if (slow != fast)
            return null;

        while (entry != slow) {
            entry = entry.next;
            slow = slow.next;
        }
        return entry;
    }

    public static void main(String[] args) {
        Node list = Node.LList(new int[] {
                3, 0, 2, 4
        });
        list.find(4).next = list.find(0);
        // System.out.println(hasCycle(list));
        System.out.println(cycleBeginNode(list));
    }
}
