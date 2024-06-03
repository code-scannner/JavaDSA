package codeforces.Round950;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = sc.narr(n);
            int b[] = sc.narr(n);
            int m = sc.nextInt();
            int d[] = sc.narr(m);
            Map<Integer, Integer> map = new HashMap<>();

            for (int num : d) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            
            boolean flag = true;
            int i = 0;

            boolean lastEleminArr = false;
            for (i = 0; i < n; i++) {
                if (b[i] == d[m - 1]) {
                    lastEleminArr = true;
                    break;
                }
            }
            for (i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    int val = map.getOrDefault(b[i], 0);
                    if (val == 0) {
                        flag = false;
                        break;
                    }
                    map.put(b[i], val - 1);
                }
            }

            out.println(flag && lastEleminArr ? "YES" : "NO");

        }

        out.close();
    }

    public static void reverse(int arr[]) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;
            right--;
        }
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