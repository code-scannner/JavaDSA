package DSA;

import java.util.*;

class LRU {
    static class DLLNode {
        int key;
        int val;
        DLLNode prev;
        DLLNode next;

        DLLNode(int k, int v) {
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }

    static class DLLQ {
        DLLNode head = null;
        DLLNode tail = null;

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

        DLLNode offerLast(int key, int val) {
            if (head == null) {
                head = new DLLNode(key, val);
                tail = head;
                return head;
            } else {
                tail.next = new DLLNode(key, val);
                tail.next.prev = tail;
                tail = tail.next;
                return tail;
            }
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
            n.next = null;
            n.prev = null;
        }

    }

    int cap;
    int size = 0;
    Map<Integer, DLLNode> map = new HashMap<>();
    DLLQ cache = new DLLQ();

    public LRU(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        DLLNode n = map.get(key);
        cache.remove(n);
        cache.addLast(n);
        return n.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLLNode n = map.get(key);
            n.val = value;
            cache.remove(n);
            cache.addLast(n);
        } else {
            if (size == cap) {
                DLLNode n = cache.pollFirst();
                map.remove(n.key);
                size--;
            }
            map.put(key, cache.offerLast(key, value));
            size++;
        }
    }
}

public class LRUCache {
    public static void main(String[] args) {
        LRU lru = new LRU(10);
        lru.put(10, 13);
        lru.put(3, 17);
        lru.put(6, 11);
        lru.put(10, 5);
        lru.put(9, 10);

    }
}