package codeforces.Round932;

import java.util.PriorityQueue;
import java.util.Scanner;

public class A {
    public static String sol(int n, String str) {
        PriorityQueue<String> q = new PriorityQueue<>();
        q.offer(str);
        StringBuilder s = new StringBuilder(str);
        s.reverse();
        q.offer(s.toString() + str);
        return q.peek();
    }    
    public static void main(String[] args) {
        Scanner sc  = new Scanner (System.in);
        int t = sc.nextInt();
        for(int i = 0 ;i<t; i++){
            int n = sc.nextInt();
            String str = sc.next();
            System.out.println(sol(n, str));
        }

        sc.close();

    }
}
