package codeforces.Round952;

import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            long max = 0;
            int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
            long k = sc.nextLong();
            for(int i = 1; i<=x; i++){
                if(k%i != 0) continue;
                long num = k/i;
                for(int j = 1; j<=y; j++){
                    if(num % j != 0) continue;
                    long l = num/j;
                    if(l > z) continue;
                    // out.printf("x = %d, y = %d, z = %d\n", i, j,l);
                    max = Math.max(max, count(x, y, z, (long)i, (long)j,l)); // TODO: check after ward if removing long works
                }
            }
            out.println(max);
        }
        

        out.close();
    }

    public static long count(long x, long y, long z, long a, long b, long c){
        // number of positions to fit box
        return (x - a + 1)* (y - b + 1) *(z - c + 1);
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