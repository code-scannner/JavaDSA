package competitions.amazon_hackathon_season_6;

import java.util.*;

public class Utkarsh1 {

    public static int fact(int n, int range) {
        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % range;
        }

        return (int) result;
    }

    public static int sol(int n, int arr[]) {
        int mod = (int) 1e9 + 7;
        Map<Integer, Integer> map = new HashMap<>();
        long res = 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            min = Math.min(num, min);
            max = Math.max(num, max);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            int val = map.get(key);
            res = (res * fact((key == min || key == max) ? val : val - 1, mod)) % mod;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int j = 0; j < n; j++) {
            arr[j] = sc.nextInt();
        }
        System.out.println(sol(n, arr));
        sc.close();
    }

}
