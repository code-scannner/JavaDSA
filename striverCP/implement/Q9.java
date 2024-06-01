package striverCP.implement;

import java.util.*;
import java.io.*;

public class Q9 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int arr[] = sc.narr(n);
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int maxIdx = 0, minIdx = n - 1;
        for(int i = 0 ;i<n; i++){
            int num = arr[i];
            if(num > max){
                maxIdx = i;
                max = num;
            }
            if(num <= min){
                min = num;
                minIdx = i;
            }
        }
        System.out.println(maxIdx + (n - 1 - minIdx) - (maxIdx > minIdx ? 1 : 0));

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