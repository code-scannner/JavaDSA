package linkedlist;

import java.util.*;

public class NextGreaterNode {
    public static int[] nextLargerNodes(Node head) {
        Node curr = head;
        Node prev = null;
        int size = 0;
        while (curr != null) {
            size++;
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // head is the new head for reversed list
        curr = prev;
        int result[] = new int[size];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < size; i++) {
            while (!stk.isEmpty() && stk.peek() <= curr.val) {
                stk.pop();
            }
            result[i] = stk.isEmpty() ? 0 : stk.peek();
            stk.push(curr.val);
            curr = curr.next;
        }

        for (int i = size / 2 - 1; i >= 0; i--) {
            int temp = result[i];
            result[i] = result[size - i - 1];
            result[size - i - 1] = temp;
        }

        return result;

    }

    public static void main(String[] args) {
        Node list = Node.LList(new int[] {
                1, 7, 5, 1, 9, 2, 5, 1
        });

        System.out.println(Arrays.toString(nextLargerNodes(list)));

    }
}
