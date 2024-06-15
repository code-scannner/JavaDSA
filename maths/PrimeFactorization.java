package maths;
import java.util.*;

public class PrimeFactorization {
    public static List<Integer> factors(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i = 2; (long)i *i <= n; i++){
            while(n%i == 0) {
                result.add(i);
                n/=i;
            }
        }
        
        if(n != 1) result.add(n);
        return result;
    }

    // faster seive of eranthanosis
    public static int countFactors(int n) {
        int max = n + 1;
        int factors[] = new int[max + 1];
        for (int i = 2; i <= max; i++) {
            if (factors[i] == 0) {
                for (int j = i; j <= max; j += i) {
                    factors[j] = factors[j / i] + 1;
                }
            }
        }
        return factors[n];
    }
    public static void main(String[] args) {
        System.out.println(factors(2));
        System.out.println(countFactors(30));
    }
}
