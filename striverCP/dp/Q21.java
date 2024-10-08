package striverCP.dp;

import java.util.*;
import java.io.*;

public class Q21 {

    static int n, m;

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        long number = sc.nextLong();
        m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        int freq[] = new int[10];
        while(number > 0){
            int digit = (int)(number%10);
            list.add(digit);
            freq[digit]++;
            number/=10;
        }

        n = list.size();

        long dp[][] = new long[1 << n][m];
        for (long arr[] : dp)
            Arrays.fill(arr, -1L);

        long ans = memo(dp, list, 0, 0, 0);

        out.println(ans);

        out.close();
    }

    public static long memo(long dp[][], List<Integer> list, int i, int rem, int bit) {
        if (i == n)
            return rem == 0 ? 1 : 0;
        if (dp[bit][rem] != -1)
            return dp[bit][rem];
        long count = 0;
        boolean visited[] = new boolean[10];
        for (int j = 0; j < n; j++) {
            if(visited[list.get(j)]) continue;
            if (((1 << j) & bit) == 0) {
                if(i == 0 && list.get(j) == 0) continue;
                count += memo(dp, list, i + 1, (rem * 10 + list.get(j)) % m, bit | (1 << j));
                visited[list.get(j)] = true;
            }
        }

        return dp[bit][rem] = count;
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