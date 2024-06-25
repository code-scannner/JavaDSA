package codechef;

import java.util.*;
import java.io.*;

class Codechef {

    public static void main(String[] args) throws IOException, java.lang.Exception {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long c = sc.nextLong();
            int a[] = sc.narr(n);
            long strength[] = new long[n];
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    long s = (long)a[i]*a[j];
                    strength[i] += s;
                    strength[j] += s;
                }
            }
            if(strength[0] <= c) out.println(0);
            boolean visited[] = new boolean[n];

            for(int i = 0; i<n; i++){
                long currMin = Long.MAX_VALUE;
                int currCity = -1;
                for(int j = 0;j<n; j++){
                    if(!visited[j]){
                        if(currMin < strength[j]){
                            currMin = strength[j];
                            currCity = j;
                        }
                    }
                }
                visited[currCity] = true;
                if(currCity != -1){
                    for(int j = 0; j<n; j++){
                        if(!visited[j]) strength[j] -= (long)a[currCity]*a[j];
                    }
                }
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