package codeforces.Round939;
import java.util.*;

public class C {
    public static void sol(int n ) {
        int maxSum = 0;
        StringBuilder str = new StringBuilder();
        for(int i = 1;i<= n; i++){
            maxSum += (2*i - 1)*i;
            str.append(i + " ");
        }
        int operations = 2*n;

        System.out.println(maxSum + " " + operations);

        for(int i = n; i>=1; i--){
            System.out.print(1 + " ");
            System.out.print(i + " ");
            System.out.println(str);
            System.out.print(2 + " ");
            System.out.print(i + " ");
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sol(n);
        }
        sc.close();    
    }
}
