package striverCP.graph;

import java.util.*;
import java.io.*;

public class Q1 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt();

        out.print(cnt(n, m));

        out.close();
    }

    public static int cnt(int n, int m) {
        boolean map[] = new boolean[20001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        map[n] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int node = q.poll();
                if (node == m)
                    return cnt;
                if (node - 1 > 0 && !map[node - 1]) {
                    map[node - 1] = true;
                    q.offer(node - 1);
                }
                if (node * 2 <= 20000 && !map[node * 2]) {
                    map[node * 2] = true;
                    q.offer(2 * node);
                }
            }
            cnt++;
        }
        return -1;
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