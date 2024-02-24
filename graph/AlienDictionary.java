package graph;

import java.util.*;

public class AlienDictionary {
    public static String dictOrder(String[] words) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            String str1 = words[i];
            String str2 = words[i + 1];
            for (int j = 0; j < str1.length() && j < str2.length(); j++) {
                char c1 = str1.charAt(j);
                char c2 = str2.charAt(j);
                while(list.size() <= c1 - 'a') list.add(new ArrayList<>());
                if (c1 != c2) {
                    if (!list.get(c1 - 'a').contains(c2 - 'a')) {
                        list.get(c1 - 'a').add(c2 - 'a');
                    }
                    break;
                }
            }
        }

        List<Integer> res = TopoSort.bfs(list);
        StringBuilder str = new StringBuilder();
        for(int i : res){
            str.append((char)('a' + i));
        }
        return str.toString();

    }

    public static void main(String[] args) {
        String[] words = { "baa", "abcd", "abca", "cab", "cad" };
        // String[] words = {
        //         "bbbbc", "bba", "aaaaac"
        // };

        System.out.println(dictOrder(words));

    }
}
