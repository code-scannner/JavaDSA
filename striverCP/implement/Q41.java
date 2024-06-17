package striverCP.implement;

import java.util.*;
import java.io.*;

public class Q41 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), x =sc.nextInt(), y = sc.nextInt();
        int arr[] = sc.narr(n);
        int idx = -1;
        for(int i = 0; i< n; i++){
            if(isNotSoRainy(i, arr, x, y)){
                idx = i;
                break;
            }
        }
        out.println(idx + 1);

        out.close();
    }
    public static boolean isNotSoRainy(int d,int arr[], int x, int y) {
        for(int i = d - 1; i>=0 && x > 0; i--, x--){
            if(arr[d] > arr[i]) return false;
        }
        for(int i = d + 1; i<arr.length && y > 0; i++, y--){
            if(arr[d] > arr[i]) return false;
        }
        return true;
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