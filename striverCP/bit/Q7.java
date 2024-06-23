package striverCP.bit;

import java.util.*;
import java.io.*;

public class Q7 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt();
        int mat[][] = new int[n][m];
        for (int i = 0; i < n; i++)
            mat[i] = sc.narr(m);

        List<Integer> indices = possible(mat, n, m);

        if (indices.size() == 0)
            out.println("NIE");
        else {
            out.println("TAK");
            for (int i : indices)
                out.print(i + " ");
            out.println();
        }

        out.close();
    }

    public static List<Integer> possible(int[][] mat, int n, int m) {
        List<Integer> list = new ArrayList<>();
        int xor = 0;
        for (int i = 0; i < n; i++) {
            list.add(1);
            xor ^= mat[i][0];
        }

        if(xor != 0) return list;

        for (int i = 0; i < n; i++) {
            xor ^= mat[i][0];
            for (int j = 1; j < m; j++) {
                if ((xor ^ mat[i][j]) != 0) {
                    list.set(i, j + 1);
                    return list;
                }
            }
            xor ^= mat[i][0];
        }

        list.clear();
        return list;
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