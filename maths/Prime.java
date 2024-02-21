package maths;
import java.util.*;

public class Prime {
    public static boolean checkPrime(int n) {
        if(n == 1) return false;
        int sqrt = (int)Math.sqrt(n);
        for(int i = 2; i<=sqrt; i++){
            if(n%i == 0) return false;
        }
        return true;


        // return !sieveOfEratosthenes(n)[n];
    }
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean seive[] = new boolean[n + 1];
        seive[0] = true;
        seive[1] = true;
        for (int i = 2; i <=n; i++) {
            if(!seive[i]){
                for (int j = i*i; j <= n; j+=i) {
                    seive[j] = true;
                }
            }            
        }

        return seive;
    }
    public static int countPowers(int n) {
        boolean[] seive = sieveOfEratosthenes(n);
        int count [] = new int[n + 1];
        List<Integer> primes = new ArrayList<>();
        
        for (int i = 2; i <= n; i++) {
            if (seive[i]) {
                for (int prime : primes) {
                    if(i%prime == 0){
                        count[i] = 1 + count[i/prime];
                        break;
                    }
                }
            }
            else{
                primes.add(i);
                count[i] = 1;
            }
        }

        int sum = 0;
        for (int elem : count) {
            sum += elem;
        }
        return sum;
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

    public static void main(String[] args) {

        // System.out.println(countPrimes(10));
        // System.out.println(countPrimes(20));
        // System.out.println(countPrimes(12,17));
        // System.out.println(countPowers(12));
        System.out.println(checkPrime(19));
        System.out.println(checkPrime(1));
        System.out.println(checkPrime(191));

        

    }
}
