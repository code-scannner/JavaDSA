package codeforces.Round25;
import java.util.*;

public class A {
    public static boolean sol(int n , String str) {
        int prev = -1;
        int curr = -1;
        int cnt = 0;
        int i = 0;
        for(char c : str.toCharArray()){
            if(c == '1'){
                prev = curr;
                curr = i;
                cnt++;
            }
            i++;
        }

        if(cnt % 2 == 0){
            return cnt == 2 ? curr - prev != 1 : true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n =  sc.nextInt();
            String str = sc.next();
            System.out.println(sol(n, str) ? "YES" : "NO");
        }
        sc.close();
    }
}
