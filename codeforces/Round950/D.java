package codeforces.Round950;

import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = sc.narr(n);

            out.println(isPossible(n, a) ? "YES" : "NO");

        }

        out.close();
    }

    public static int gcd(int d, int rem) {
        if (rem == 0)
            return d;
        return gcd(rem, d % rem);
    }

    public static boolean isPossible(int n, int arr[]) {
        int prev = gcd(arr[0], arr[1]);
        int i;
        for(i = 2; i<n; i++){
            int next = gcd(arr[i - 1] , arr[i]);
            if(next < prev){
                break;
            }
            prev = next;
        }
        if(i >= n - 1) return true;

        return remove(n, arr, i - 2) || remove(n, arr, i) || remove(n, arr, i - 1);

    }

    public static boolean remove(int n, int arr[], int rmIndex) {
        int prev = gcd(arr[0], arr[1]);
        if(rmIndex == 1) prev = gcd(arr[0], arr[2]);

        for(int i = 2; i<n; i++){
            if(i == rmIndex) continue;
            int next = gcd(arr[i], i - 1 == rmIndex ? arr[i - 2] : arr[i - 1]);
            if(next < prev) return false;
            prev = next;
        }

        return true;
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

        int[][] matrix(int n, int m) throws IOException {
            int result[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                result[i] = narr(m);
            }
            return result;
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