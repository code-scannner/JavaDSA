package striverCP.stackqueue;

import java.util.*;
import java.io.*;

public class Q7 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), x = sc.nextInt();
            int heights[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                heights[i] = new int[] { sc.nextInt(), i };
            }

            Arrays.sort(heights, (a, b) -> b[0] - a[0]);
            int result[] = new int[n];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

            for (int i = 0; i < m; i++) {
                result[heights[i][1]] = i + 1;
                pq.offer(new int[] { heights[i][0], i + 1 });
            }

            for (int i = m; i < n; i++) {
                int node[] = pq.poll();
                node[0] += heights[i][0];
                result[heights[i][1]] = node[1];
                pq.offer(node);
            }
            
            int min = pq.peek()[0];
            int max = min;
            while (!pq.isEmpty())
                max = pq.poll()[0];
            if (max - min <= x) {
                out.println("YES");
                for (int j = 0; j < n; j++) {
                    out.print(result[j] + " ");
                }
                out.println();
            } else
                out.println("NO");

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