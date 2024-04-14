package strings;

import java.util.*;

public class Combination {
    public static void main(String[] args) {
        String str = "abcdefghi";
        System.out.println(combination(str, 8));
    }

    static List<String> list = new ArrayList<>();

    public static List<String> combination(String str, int l) {
        StringBuilder comb = new StringBuilder();
        recursion(str, 0, comb, l);
        return list;
    }

    public static void recursion(String str, int i, StringBuilder comb, int l) {
        if (comb.length() == l) {
            list.add(comb.toString());
        }
        if (i == str.length())
            return;

        for (; i < str.length(); i++) {
            comb.append(str.charAt(i));
            recursion(str, i + 1, comb, l);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}
