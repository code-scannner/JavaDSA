package maths;
import java.util.*;

public class SieveOfEratosthenes {

    public static long countPowers(int n) {
        boolean[] primes = new boolean[n + 1];
        long count = 0;
        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                for (int j = i; j <= n; j += i) {
                    count++;
                    primes[j] = true;
                }
                for(int j = i; j<=n;j*=i){
                    primes[j] = false;
                }
                System.out.printf("i = %d, count = %d primes = %s\n", i, count, Arrays.toString(primes));
                
            }
        }
        return count;
    }
    
    public static int countPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                count++;
                for (int j = i; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }

        return count;
    }

    public static int countPrimes(int a, int b) {
        return countPrimes(b) - countPrimes(a - 1);
    }

    public static void main(String[] args) {

        // System.out.println(countPrimes(10));
        // System.out.println(countPrimes(20));
        // System.out.println(countPrimes(10, 20));
        // 2,3,4,5,6,7,8
        // 0,0,0,0,0,0,1
        // 1,1,2,1,2,1,3
        System.out.println(countPowers(8));

    }
}
