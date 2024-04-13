package codeforces.Round938;

import java.util.Scanner;

public class A {
    public static int sol(int n, int a, int b) {
        if(2*a > b){
            return (n%2)*a + (n/2)*b;
        }
        else return n*a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(sol(n, a, b));
        }
        
        sc.close();

    }
}
