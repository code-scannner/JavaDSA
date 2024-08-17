package codeforces.aug13;

import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = sc.narr(n);
            boolean occupied [] = new boolean[n + 1];
            boolean ispossible = true;
            for(int i = 0; i<n; i++){
                if(i == 0){
                    occupied[arr[i]] = true;
                }
                else{
                    int toseated = arr[i];
                    if(toseated != n && occupied[toseated + 1] || toseated != 1 && occupied[toseated - 1]){
                        occupied[toseated] = true;
                    }
                    else{
                        ispossible = false;
                        break;
                    }
                }
            }

            out.println(ispossible ? "YES" : "NO");
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