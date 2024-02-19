package codeforces.Round928;
import java.util.*;

public class A {
    public static String sol(String str) {
        int a = 0, b = 0;
        for(int i = 0 ; i<5; i++){
            if(str.charAt(i) == 'A') a++;
            else b++;
        }
        if(a > b) return "A";
        else return "B";
        
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 0; i<tc; i++){
            String str = sc.next();
            System.out.println(sol(str));
        }
        sc.close();
    }
}
