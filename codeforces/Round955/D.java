package codeforces.Round955;
import java.util.*;
import java.io.*;
public class D {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
            int heights [][] = new int[n][m];
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    heights[i][j] = sc.nextInt();
                }
            }
            char[][] type = new char[n][m];
            for(int i = 0; i<n; i++) type[i] = sc.next().toCharArray();
            
            int prefixSum[][] = new int[n + 1][m + 1];
            long type0 = 0, type1 = 0;
            for(int i = 0; i<n; i++){
                for(int j = 0; j<m; j++){
                    
                    if(type[i][j] == '0') type0 += heights[i][j];
                    else type1 += heights[i][j];
                    prefixSum[i + 1][j + 1] = type[i][j] - '0';
                    prefixSum[i + 1][j + 1] += prefixSum[i][j + 1] + prefixSum[i + 1][j] - prefixSum[i][j];
                }
            }
            
            long diff = Math.abs(type0 - type1);
            
            out.println(isPossible(prefixSum, n, m, k, diff) ? "YES" : "NO");

        }

        out.close();
    }

    public static boolean isPossible(int prefix[][], int n, int m, int k, long diff) {
        if(diff == 0) return true;
        int prevDiff = -1;
        for(int i = k; i<=n; i++){
            for(int j = k; j<=m; j++){
                int currtype = prefix[i][j] - prefix[i - k][j] - prefix[i][j - k] + prefix[i - k][j - k];
                int currDiff = Math.abs(2*currtype - k*k);
                if(currDiff == 0) continue;
                if(prevDiff != -1 && prevDiff != currDiff) return true;
                prevDiff = currDiff;
                if(diff % currDiff == 0) return true;
            }
        }

        if(prevDiff == -1) return false;
        if(diff % prevDiff == 0) return true;
        
        return false;
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