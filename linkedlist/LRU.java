package linkedlist;

import java.util.*;

import DSA.DLL;
import DSA.DLLNode;

public class LRU {
    static Map<Integer, DLLNode> map;
    static DLL list;
    static int capacity;

    public static void LRUCache(int _c) {
        map = new HashMap<>();
        list = new DLL();
        capacity = _c;
    }


    public static int get(int key) {
        if (map.containsKey(key)) {
            list.insertEnd(list.extractNode(map.get(key)));
            return map.get(key).val;
        }

        return -1;
    }

    public static void put(int key, int value) {

        int found = get(key);
        if (found != -1) {
            map.get(key).val = value;
            return;
        }

        if (map.size() >= capacity) {
            map.remove(list.removeFront().val);
        }

        DLLNode node = new DLLNode(value);
        map.put(key, node);
        list.insertEnd(node);

    }

    public static void main(String[] args) {
        LRUCache(2);
        put(1, 1);
        put(2, 2);
        System.out.println(get(1));
        put(3, 3);
        System.out.println(get(2));
        put(4, 4);
        put(4, 8);
        System.out.println(get(1));
        System.out.println(get(3));
        System.out.println(get(4));

    }

}
