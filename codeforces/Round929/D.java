package codeforces.Round929;
import java.util.*;

public class D {
    public static String sol(int [] arr) {
        int min = arr[0];
        int cnt = 1;
        for(int i = 1; i<arr.length; i++){
            if(min == arr[i]) cnt++;
            else if(arr[i] < min) {
                min = arr[i];
                cnt = 1;
            }
        }
        if(cnt == 1) return "YES";
        if(min == 1) return "NO";
        for(int i = 0; i<arr.length; i++){
            if(arr[i] % min != 0) return "YES";
        }
        return "NO";
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
