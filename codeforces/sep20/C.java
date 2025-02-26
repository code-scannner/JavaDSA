package codeforces.sep20;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            StringBuilder str = new StringBuilder();
            out.println("? 0");
            out.flush();
            int isValid = sc.nextInt();
            str.append(isValid == 1 ? '0' : '1');
            while (str.length() < n) {
                out.println("? " + str.toString() + "0");
                out.flush();
                int canZero = sc.nextInt();
                out.println("? " + str.toString() + "1");
                out.flush();
                int canOne = sc.nextInt();
                if (canOne == 0 && canZero == 0)
                    break;
                if (canOne == 1)
                    str.append('1');
                else
                    str.append('0');
            }

            while (str.length() < n) {
                out.println("? 0" + str.toString());
                out.flush();
                int canZero = sc.nextInt();
                str.insert(0, canZero == 1 ? "0" : "1");
            }

            out.println("! " + str.toString());
            out.flush();

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

        void sort(int arr[]) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                list.add(arr[i]);
            Collections.sort(list);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
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