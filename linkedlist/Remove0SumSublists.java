package linkedlist;

import java.util.*;

public class Remove0SumSublists {
    public static Node removeZeroSumSublists(Node head) {
        Map<Integer, Node> map = new HashMap<>();
        Node curr = head;
        int presum = 0;
        while (curr != null) {
            presum += curr.val;
            map.put(presum, curr);
            curr = curr.next;
        }

        System.out.println(map);

        if (map.containsKey(0))
            return map.get(0).next;
        presum = 0;
        curr = head;
        while (curr != null) {
            presum += curr.val;
            if (map.containsKey(presum) && map.get(presum) != curr) {
                System.out.println(presum);
                curr.next = map.get(presum).next;
                break;
            }
            curr = curr.next;
        }
        return head;

    }

    public static void main(String[] args) {
        // Node list = Node.LList(new int[] {
        // 1, 2, -3, 3, 1
        // });
        Node list = Node.LList(new int[] {
                1, 2, 3, -3, 4
            // 1   3  6  3  7 
        });

        System.out.println(removeZeroSumSublists(list));

    }
}
