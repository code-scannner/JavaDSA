package utilities;

import java.util.*;

public class LinkedHashSetDemo {

    static class Token {
        int id;
        int time;

        Token(int id, int time) {
            this.id = id;
            this.time = time;
        }

        public String toString() {
            return "[" + this.id + "," + this.time + "]";
        }
    }

    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(1); set.add(0); set.add(2); set.add(-1);
        // set.remove(0);
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()){
            set.remove(iter.next());
            System.out.println(set);
        }

        System.out.println(set);
    }
}
