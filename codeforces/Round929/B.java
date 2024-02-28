package codeforces.Round929;
import java.util.*;

public class B {
    public static int sol(int [] arr) {
        int sum = 0;
        int ones = 0;
        for(int num : arr) {
            sum += num;
            if(num % 3 == 1) ones++;
        }
        if(sum %3 == 0) return 0;
        if(sum %3 == 2) return 1;
        if(sum %3 == 1){
            if(ones > 0) return 1;
            return 2;
        }

        return 1;
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
