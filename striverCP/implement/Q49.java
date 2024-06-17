package striverCP.implement;

import java.util.*;
import java.io.*;

public class Q49 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        boolean negFloor = true;
        boolean posFloor = true;
        int arr[] = sc.narr(n);

        for (int num : arr) {
            if (num % 2 == 0)
                out.print(num/2);
            else {
                if (num < 0) {
                    if (negFloor)
                        out.print(num / 2);
                    else
                        out.print((num - 1) / 2);
                    negFloor = !negFloor;
                } else {
                    if (posFloor)
                        out.print(num / 2);
                    else
                        out.print((num + 1) / 2);
                    posFloor = !posFloor;

                }
            }
            out.print(" ");
        }
        out.println();

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