package codeforces.jan22;

import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            int arr[] = sc.narr(n);
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i <= r; i++)
                pq.offer(arr[i]);
            int size = r - l + 1;
            long currSum = 0;
            long ans = Long.MAX_VALUE;
            while (size > 0) {
                currSum += pq.poll();
                size--;
            }
            ans = Math.min(ans, currSum);
            
            currSum = 0;
            size = r - l + 1;
            pq.clear();
            for (int i = l; i < n; i++) {
                pq.offer(arr[i]);
            }
            while (size > 0) {
                currSum += pq.poll();
                size--;
            }
            ans = Math.min(ans, currSum);

            out.println(ans);

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