package codeforces.july28;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        int oper[] = new int[40];
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = sc.narr(n);
            int i = 0;
            for (i = 0; i < 40; i++) {
                boolean isend = true;
                for (int j = 0; j < n; j++) {
                    if (arr[j] != 0) {
                        isend = false;
                        break;
                    }
                }
                if (isend)
                    break;

                Arrays.sort(arr);
                int sub = arr[0] + (arr[n - 1] - arr[0]) / 2;
                oper[i] = sub;
                if (sub == 0)
                    break;
                for (int j = 0; j < n; j++) {
                    arr[j] = Math.abs(arr[j] - sub);
                }
            }
            boolean isPossible = true;
            for (int j = 0; j < n; j++) {
                if (arr[j] != 0) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                out.println(i);
                if (i != 0) {
                    for (int j = 0; j < i; j++) {
                        out.print(oper[j] + " ");
                    }
                    out.println();
                }
                else out.println();
            } else {
                out.println(-1);
            }

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