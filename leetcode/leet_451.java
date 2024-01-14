package leetcode;
import java.util.*;

class Pair{
    char c;
    int freq;
    Pair(char _c, int _freq){
        c = _c;
        freq = _freq;
    }
}

public class leet_451 {
    public static String frequencySort(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(s.length(), 
            (a,b)->b.freq - a.freq
        );
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            pq.add(new Pair(c, map.get(c)));
        }
        StringBuilder str = new StringBuilder();
        while (pq.size() != 0) {
            Pair pair = pq.poll();
            char c = pair.c;
            int freq = pair.freq;
            while (freq > 0) {
                str.append(c);
                freq--;
            }
        }

        return str.toString();
    }
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
