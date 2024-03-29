package codeforces.Round937;
import java.util.*;

public class E {
    public static int charsDiff(String str,String substr, int begin){
        int cnt = 0;
        for(int i = 0; i < substr.length(); i++){
            if(substr.charAt(i) != str.charAt(begin + i)){
                cnt++;
                if(cnt == 2) return 2;
            }
        }
        return cnt;
    }
    public static boolean match(String str, String substr, int chars){
        int cnt = 0;
        for(int i = 0; i<str.length(); i+=substr.length()){
            cnt += charsDiff(str, substr, i);
            if(cnt > 1) return false;
        }

        return true;
    }
    
    public static int sol(String str, int n) {
        int f = n/2;
        int min = n;
        for(int i = 1; i <= f; i++){
            if(n % i == 0){
                if(match(str,str.substring(0, i), i))
                    return i;
                if(match(str,str.substring(i, i + i), i))
                    return i;
            }
        }

        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            String str = sc.next();
            System.out.println(sol(str,a));
        }
        sc.close();
    }
}
