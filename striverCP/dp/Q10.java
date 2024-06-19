package striverCP.dp;

import java.util.*;
import java.io.*;

public class Q10 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int cost[] = new int[n];
        int vitamin[] = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
            char[] str = sc.next().toCharArray();
            int vit = 0;
            for (int j = 0; j < str.length; j++) {
                vit |= (1 << (str[j] - 'A'));
            }
            vitamin[i] = vit;
        }

        out.println(tabu(cost, vitamin));

        out.close();
    }

    public static int tabu(int cost[], int vitamin[]) {
        int n = cost.length;
        int dp[][] = new int[n + 1][8];
        Arrays.fill(dp[n], (int)1e9);
        dp[n][7] = 0;
        for(int i = n - 1; i>=0; i--){
            for(int v = 0; v<8; v++){
                int take = cost[i] + dp[i + 1][v | vitamin[i]];
                int nottake = dp[i + 1][v];
                dp[i][v] = Math.min(take, nottake);
            }
        }

        return dp[0][0] >= (int)1e9 ? -1 : dp[0][0];
    }

    public static int memo(int i, int v, int dp[][], int cost[], int vitamin[]) {
        if (i == dp.length)
            return v == 7 ? 0 : (int) 1e9;
        if (dp[i][v] != -1)
            return dp[i][v];
        int take = cost[i] + memo(i + 1, v | vitamin[i], dp, cost, vitamin);
        int nottake = memo(i + 1, v, dp, cost, vitamin);
        dp[i][v] = Math.min(take, nottake);
        return dp[i][v];
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