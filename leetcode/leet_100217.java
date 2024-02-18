package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet_100217 {
    public static boolean checkPrime(int n) {
        if (n == 1)
            return false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0)
                return false;
        }
        return true;

        // return !sieveOfEratosthenes(n)[n];
    }

    public static void freqPrimes(int i, int j, int dirx, int diry, int mat[][], int prevNum,
            Map<Integer, Integer> map) {
        if (i < mat.length && i >= 0 && j < mat[0].length && j >= 0) {
            int num = prevNum * 10 + mat[i][j];
            if (num > 10 && checkPrime(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            freqPrimes(i + dirx, j + diry, dirx, diry, mat, num, map);
        }
    }

    public static int mostFrequentPrime(int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                for(int dirx = -1; dirx<=1; dirx++){
                    for(int diry = -1; diry <=1; diry++){
                        if(dirx == 0 && diry == 0) continue;
                        freqPrimes(i, j, dirx, diry, mat, 0, map);
                    }
                }
            }
        }
        int maxFreq = 0;
        int max = -1;
        for(int key : map.keySet()){
            int value = map.get(key);
            if(value > maxFreq) {
                max = key;
                maxFreq = value;
            }
            else if(value == maxFreq) max = Math.max(max, key) ;
        }

        return max;

    }

    public static void main(String[] args) {
        // int mat[][] =  {{1,1},{9,9},{1,1}};
        int mat[][] =  {{9,7,8},{4,6,5},{2,8,6}};
        System.out.println(mostFrequentPrime(mat));
    }
}
