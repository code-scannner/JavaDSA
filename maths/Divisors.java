package maths;
import java.util.*;

public class Divisors {
    public static List<Integer> divisors(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i = (int)Math.sqrt(n); i>=1; i--){
            if(n % i == 0){
                if(i*i == n) result.add(i);
                else {
                    result.add(i);
                    result.add(n / i);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(divisors(20));
        System.out.println(divisors(91));
        System.out.println(divisors(23));
        System.out.println(divisors(1));
        System.out.println(divisors(105*105*105*105));
        System.out.println(divisors(1001));
    }
}


