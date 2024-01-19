package linkedlist;

import java.util.*;

public class CriticalNodes {
    public static int[] nodesBetweenCriticalPoints(Node head) {
        int first = -1, pInd = -1, min = -1, i = 1;

        Node prev = head;
        Node curr = head.next;

        while (curr != null && curr.next != null) {

            boolean flag = false;
            flag |= curr.val > prev.val && curr.val > curr.next.val;
            flag |= curr.val < prev.val && curr.val < curr.next.val;

            // if flag = true critical elem found
            if (flag) {
                if (pInd == -1) {
                    pInd = i;
                    first = i;
                } else {
                    if (min == -1)
                        min = i - pInd;
                    else
                        min = Math.min(min, i - pInd);
                    pInd = i;
                }
            }

            prev = curr;
            curr = curr.next;
            i++;

        }

        int[] result = new int[2];
        result[0] = min;
        result[1] = min == -1 ? -1 : pInd - first;

        return result;
    }

    public static void main(String[] args) {
        // Node list = Node.LList(new int[] {
        // 5, 3, 1, 2, 5, 1, 2
        // });
        Node list = Node.LList(new int[] {
                1, 3, 2, 2, 3, 2, 2, 2, 7
        });
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(list)));
    }
}
