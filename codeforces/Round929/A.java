package codeforces.Round929;
import java.util.*;

public class A {
    public static int sol(int [] arr) {
        int sum = 0;
        for(int num : arr) sum += Math.abs(num);
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 0; i<tc; i++){
            int n = sc.nextInt();
            int [] arr = new int[n];
            for(int j = 0; j<n; j++) arr[j] = sc.nextInt();
            System.out.println(sol(arr));
        }
        sc.close();
    }
}
