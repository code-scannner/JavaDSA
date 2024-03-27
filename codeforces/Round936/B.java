package codeforces.Round936;
import java.util.*;

public class B {
    public static long pow(int n , int x, int range) {
        long result = 1L;
        while (x > 0) {
            if((x&1) == 1){
                result = (result * n)%range;
            }
            n = (int)(((long)n*n)%range);
            x>>=1;
        }

        return result;
    }
    public static int sol(int arr[], int k) {
        int mod = (int)1e9 + 7;
        int n = arr.length;
        long max = 0, s = 0, sum = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];
            s += arr[i];
            if(s < 0) s = 0;
            max = Math.max(max, s);
        }
        max = max % mod;
        sum = sum % mod;
        sum = (sum + (max * (pow(2, k, mod) - 1 + mod)%mod)%mod + mod)%mod;
        return (int)sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(sol(arr, k));
        }

        sc.close();
    }
}
