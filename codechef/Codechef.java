package codechef;

import java.util.*;
import java.io.*;

class Codechef {

    public static void main(String[] args) throws IOException, java.lang.Exception {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int arr[] = sc.narr(n);
            long ans = solve(arr, n, k);

            out.println(ans);
        }

        out.close();

    }

    public static long solve(int arr[], int n, int k) {
        long res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { arr[i], i });
        }
        while (pq.size() > k)
            pq.poll();

        int firstIdx = n;
        int firstNum = 0;
        int lastIdx = -1;
        int lastNum = 0;

        while (!pq.isEmpty()) {
            int num[] = pq.poll();
            res += 2 * num[0];
            if (firstIdx > num[1]) {
                firstIdx = num[1];
                firstNum = num[0];
            }
            if (lastIdx < num[1]) {
                lastIdx = num[1];
                lastNum = num[0];
            }
        }

        return res - firstNum - lastNum;
    }

    public static boolean checkPrime(int n) {
        if (n <= 1)
            return false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0)
                return false;
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