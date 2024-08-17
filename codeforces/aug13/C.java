package codeforces.aug13;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = sc.narr(n);

            int q = sc.nextInt();
            while (q-- > 0) {
                String str = sc.next();
                boolean ispossible = str.length() == arr.length;
                if (!ispossible) {
                    out.println("NO");
                    continue;
                }
                Map<Character, Integer> map = new HashMap<>();
                Map<Integer, Character> map2 = new HashMap<>();

                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (map.containsKey(c)) {
                        if (map.get(c) != arr[i] || map2.containsKey(arr[i]) && map2.get(arr[i]) != c) {
                            ispossible = false;
                            break;
                        }
                    } else if (map2.containsKey(arr[i])) {
                        ispossible = false;
                        break;
                    } else {
                        map.put(c, arr[i]);
                        map2.put(arr[i], c);
                    }
                }

                out.println(ispossible ? "YES" : "NO");
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