package codechef;

import java.util.*;
import java.io.*;

class Codechef {

    public static void main(String[] args) throws IOException, java.lang.Exception {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt(), h = sc.nextInt();
            long sum = 0;

            for(int b = 1; b<=n; b++){
                int res = binarySearch(b, k, h, n);
                sum += res;
            }

            out.println(sum);
        }
        out.close();
    }

    public static int binarySearch(int a, int k, int h, int n){
        if(a >= h) return n;
        int left = 1;
        int right = a - 1;
        while(left <= right){
            int b = (right + left)>>1;
            if(k > (int)Math.ceil((double)(h - a)/ (a - b))){
                left = b + 1;
            }
            else{
                right = b - 1;
            }
        }

        return right;
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