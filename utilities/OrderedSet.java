package utilities;

import java.util.*;

public class OrderedSet {
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet <>();
        set.add(10);
        set.add(10);
        set.add(11);
        set.add(11);
        set.add(8);
        System.out.println(set.tailSet(8 + 1));
        System.out.println(set.headSet(11));
        set.add(2);

    }
}
