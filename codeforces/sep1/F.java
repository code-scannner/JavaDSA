package codeforces.sep1;

import java.util.*;
import java.io.*;

public class F {
    public static long modinv(long a, int mod) {
        return a <= 1 ? a : mod - (mod / a) * modinv(mod % a, mod) % mod;
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = sc.narr(n);
            int mod = (int) 1e9 + 7;
            long sum = 0;
            long res = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
            }
            sum %= mod;
            for (int s : arr) {
                sum -= s;
                sum = (sum + mod)%mod;
                res = (res + sum * s) % mod;
            }

            res = (res * modinv(((long) n * (n - 1) / 2)%mod, mod)) % mod;

            out.println(res);
        }

        out.close();
    }

    public static long pow(long n, int x, int range) {
        long result = 1L;
        while (x > 0) {
            if ((x & 1) == 1) {
                result = (result * n) % range;
            }
            n = (int) (((long) n * n) % range);
            x >>= 1;
        }

        return result % range;
    }

    public static int[] add(int map1[], int map2[]) {
        int[] res = new int[map1.length];
        for (int i = 0; i < map1.length; i++) {
            res[i] = map1[i] + map2[i];
        }
        return res;
    }

    public static int minOpers(int map[]) {
        int max = Integer.MIN_VALUE, total = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (map[c] > 0) {
                max = Math.max(map[c], max);
                total += map[c];
            }
        }

        return total - max;
    }

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Scanner(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }

        int[] narr(int n) throws IOException {
            int result[] = new int[n];
            for (int i = 0; i < n; i++)
                result[i] = nextInt();
            return result;
        }

        void sort(int arr[]) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                list.add(arr[i]);
            Collections.sort(list);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
        }

        String[] nstr(int n) throws IOException {
            String result[] = new String[n];
            for (int i = 0; i < n; i++)
                result[i] = next();
            return result;
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(next());
        }

        boolean ready() throws IOException {
            return br.ready();
        }
    }
}