package striverCP.implement;

import java.util.*;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        StringBuilder fullSnake = new StringBuilder();
        for (int i = 0; i < m; i++)
            fullSnake.append('#');
        StringBuilder leftSnake = new StringBuilder();
        for (int i = 0; i < m; i++)
            leftSnake.append('.');
        leftSnake.setCharAt(0, '#');
        StringBuilder rightSnake = new StringBuilder();
        for (int i = 0; i < m; i++)
            rightSnake.append('.');
        rightSnake.setCharAt(m - 1, '#');
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                System.out.println(fullSnake);
            else if (i % 4 == 1)
                System.out.println(rightSnake);
            else
                System.out.println(leftSnake);
        }
        sc.close();
    }
}
