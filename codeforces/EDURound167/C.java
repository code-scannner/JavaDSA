package codeforces.EDURound167;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int movie1[] = sc.narr(n);
            int movie2[] = sc.narr(n);
            int minus = 0, plus = 0;
            int rating1 = 0, rating2 = 0;
            for (int i = 0; i < n; i++) {
                if (movie1[i] == 1 && movie2[i] == 1)
                    plus++;
                else if (movie1[i] == -1 && movie2[i] == -1)
                    minus++;
                else {
                    if (movie1[i] > movie2[i])
                        rating1 += movie1[i];
                    else
                        rating2 += movie2[i];
                }
            }

            int min = Math.min(rating1, rating2);
            int max = Math.max(rating1, rating2);

            int increment = Math.min(max - min, plus);
            min += increment;
            plus -= increment;
            min += plus/2;
            max += plus/2;
            max += plus%2;

            int decrement = Math.min(max - min , minus);
            max -= decrement;
            minus -= decrement;
            min -= minus/2 + minus%2;

            out.println(min);

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