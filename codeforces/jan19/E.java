package codeforces.jan19;

import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            int n = sc.nextInt();
            int m1 = sc.nextInt(), m2 = sc.nextInt();
            for (int i = 0; i < m1; i++) {
                int u = sc.nextInt(), v = sc.nextInt();
                if (!map.containsKey(u))
                    map.put(u, new HashSet<>());
                if (!map.containsKey(v))
                    map.put(v, new HashSet<>());
                map.get(u).add(v);
                map.get(v).add(u);
            }
            int intersection = 0;
            for (int i = 0; i < m2; i++) {
                int u = sc.nextInt(), v = sc.nextInt();
                if (map.containsKey(u) && map.get(u).contains(v)) {
                    intersection++;
                }
            }

            System.out.println(m1 + m2 - 2 * intersection);
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