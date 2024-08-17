package codeforces.aug13;

import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
            int w = sc.nextInt();
            int arr[] = sc.narr(w);

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            PriorityQueue<Long> pq2 = new PriorityQueue<>((a, b) -> b > a ? 1 : -1);
            for (int num : arr)
                pq.offer(num);

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    int first = Math.min(n - k + 1, i) - Math.max(1, i - k + 1) + 1;
                    int second = Math.min(m - k + 1, j) - Math.max(1, j - k + 1) + 1;
                    pq2.offer((long) first * second);
                }
            }

            long score = 0;
            while (!pq.isEmpty()) {
                score += pq2.poll() * pq.poll();
            }

            out.println(score);

        }

        out.close();
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