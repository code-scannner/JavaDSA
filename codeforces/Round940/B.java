package codeforces.Round940;
import java.util.*;

public class B {
    public static int[] sol(int n, int k) {
        if(n == 1) return new int[]{k};
        int [] result = new int [n];
        result[0] = (int)Math.pow(2,Math.floor(Math.log(k)/ Math.log(2))) - 1;
        result[1] = k - result[0];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int result [] = sol(n, k);
            for(int j = 0; j<n; j++){
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

}
