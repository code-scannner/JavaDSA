package striverCP.stackqueue;

import java.util.*;
import java.io.*;

public class Q6 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int arr[] = sc.narr(n);
        int prevsmaller[] = prevSmallerIndex(arr);
        int nextsmaller[] = nextSmallerIndex(arr);
        long prevdp[] = new long[n];
        long nextdp[] = new long[n];
        for (int i = 0; i < n; i++) {
            int prev = prevsmaller[i];
            prevdp[i] = arr[i] * (i - prev);
            if (prev != -1)
                prevdp[i] += prevdp[prev];
        }
        for (int i = n - 1; i >= 0; i--) {
            int next = nextsmaller[i];
            nextdp[i] = arr[i] * (next - i);
            if (next != n)
                nextdp[i] += nextdp[next];
        }
        long max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            long newmax = prevdp[i] + nextdp[i] - arr[i];
            if (newmax > max) {
                idx = i;
                max = newmax;
            }
        }

        for (int i = idx + 1; i < n; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1]);
        }
        for (int i = idx - 1; i >= 0; i--) {
            arr[i] = Math.min(arr[i], arr[i + 1]);
        }

        for (int i = 0; i < n; i++)
            out.print(arr[i] + " ");

        out.close();
    }

    public static int[] prevSmallerIndex(int arr[]) {
        int n = arr.length;
        int result[] = new int[n];
        Stack<int[]> stk = new Stack<>();
        stk.push(new int[] { -1, Integer.MIN_VALUE });
        for (int i = 0; i < n; i++) {
            while (stk.peek()[1] > arr[i])
                stk.pop();
            result[i] = stk.peek()[0];
            stk.push(new int[] { i, arr[i] });
        }
        return result;
    }

    public static int[] nextSmallerIndex(int arr[]) {
        int n = arr.length;
        int result[] = new int[n];
        Stack<int[]> stk = new Stack<>();
        stk.push(new int[] { n, Integer.MIN_VALUE });
        for (int i = n - 1; i >= 0; i--) {
            while (stk.peek()[1] > arr[i])
                stk.pop();
            result[i] = stk.peek()[0];
            stk.push(new int[] { i, arr[i] });
        }
        return result;
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