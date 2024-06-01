package striverCP.maths;

import java.util.*;

public class Q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (t-- > 0) {
            int k = sc.nextInt();
            int r = sc.nextInt();
            for(int i = 1 ; i<=10; i++){
                if(k*i % 10 == r || k *i % 10 == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
        sc.close();
    }
}