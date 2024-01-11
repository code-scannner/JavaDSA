package gfg;

import java.util.*;

public class RemoveKdigits {
    public static String removeKdigits(String S, int K) {
        Stack<Character> stk = new Stack<>();
        for (char c : S.toCharArray()) {
            while (!stk.isEmpty() && K > 0 && stk.peek() > c) {
                stk.pop();
                K--;
            }
            stk.push(c);
            while (stk.size() == 1 && stk.peek() == '0') {
                stk.pop();
            }

        }

        while (K > 0 && !stk.isEmpty()) {
            stk.pop();
            K--;
        }

        if (stk.isEmpty())
            return "0";

        StringBuilder str = new StringBuilder();
        for (char c : stk) {
            str.append(c);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String S = "9734214024556503587";
        int K = 12;
        System.out.println(removeKdigits(S, K));
    }
}
