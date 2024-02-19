package codeforces.Round928;
import java.util.*;

public class C {
    static int [] dp = new int[200001];
    static int digitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num/=10;
        }
        return sum;
    }
    static {
        int sum = 0;
        for(int i = 0; i<dp.length; i++){
            sum += digitSum(i);
            dp[i] = sum;
        }
    }
    public static int func(int num){
        return dp[num];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 0; i<tc; i++){
            int num = sc.nextInt();
            System.out.println(func(num));
        }
        sc.close();
    }    
}
