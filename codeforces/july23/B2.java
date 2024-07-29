package codeforces.july23;

import java.util.*;
import java.io.*;

public class B2 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long m = sc.nextLong();
            int arr[] = sc.narr(n);
            int c[] = sc.narr(n);
            List<int[]> flowers = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                flowers.add(new int[] { arr[i], c[i] });
            }
            flowers.sort((a, b) -> a[0] - b[0]);
            
            long max = 0;
            for (int i = 0; i < n; i++) {
                int cost = flowers.get(i)[0];
                int freq = flowers.get(i)[1];
                long canTake = Math.min(m / cost, freq);
                max = Math.max(max, canTake * cost);
            }

            for (int i = 0; i < n - 1; i++) {
                
                int greater = flowers.get(i)[0];
                int smaller = flowers.get(i + 1)[0];
                if(greater - smaller != 1)  continue;
                int great_freq = flowers.get(i)[1];
                int smaller_freq = flowers.get(i + 1)[1];

                long can_take = Math.min(m / greater, great_freq);
                long sum = can_take * greater;
                long remain = m - sum;
                
                can_take = Math.min(remain / smaller, smaller_freq);
                sum += can_take * smaller;
                max = Math.max(sum, max);

                // remain = 205;
                if(remain < smaller && smaller_freq >= smaller - remain){
                    max = Math.max(max, m);
                    break;
                }
            }

            out.println(max);

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