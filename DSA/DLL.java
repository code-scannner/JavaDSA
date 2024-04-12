package DSA;

import java.util.*;

class DLLNode {
    int val;
    DLLNode prev;
    DLLNode next;

    DLLNode(int v) {
        val = v;
        prev = null;
        next = null;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}

public class DLL {
    DLLNode head = null;
    DLLNode tail = null;

    @Override
    public String toString() {
        List<Integer> result = new ArrayList<>();
        DLLNode cur = head;
        while (cur != null) {
            result.add(cur.val);
            cur = cur.next;
        }

        return result.toString();
    }

    DLLNode offerLast(int val) {
        if (head == null) {
            head = new DLLNode(val);
            tail = head;
            return head;
        } else {
            tail.next = new DLLNode(val);
            tail.next.prev = tail;
            tail = tail.next;
            return tail;
        }
    }

    DLLNode offerFirst(int val) {
        if (head == null) {
            head = new DLLNode(val);
            tail = head;
            return head;
        } else {
            DLLNode ret = new DLLNode(val);
            ret.next = head;
            head.prev = ret;
            head = ret;
            return ret;
        }
    }

    DLLNode pollFirst() {
        if (head == null)
            return null;
        DLLNode ret = head;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return ret;
    }

    DLLNode pollLast() {
        if (tail == null)
            return tail;
        DLLNode ret = tail;
        if (tail.prev == null) {
            tail = null;
            head = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return ret;
    }

    void remove(DLLNode n) {
        if (n == null)
            return;
        else if (n.prev == null) {
            head = head.next;
            if (head != null)
                head.prev = null;
            else
                tail = null;
        } else if (n.next == null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }

        // the removed node should not be having prev and next pointers
        n.next = null;
        n.prev = null;
    }

    void addLast(DLLNode n) {
        if (tail == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = tail.next;
        }
    }

    void addFirst(DLLNode n) {
        if (head == null) {
            head = n;
            tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

}
