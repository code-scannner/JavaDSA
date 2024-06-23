package striverCP.bit;

import java.util.*;
import java.io.*;

public class Q6 {
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int blocks[] = sc.narr(4);
            boolean possible = false;
            for (int i = 0; i < 16; i++) {
                if(isPossible(i, blocks, n)){
                    possible = true;
                    break;
                }
            }
            out.println(possible ? "YES": "NO");
        }

        out.close();
    }

    public static boolean isPossible(int corners, int [] blocks, int n) {
        for(int i = 0; i<4; i++){
            int needed = blocks[i];
            boolean leftPresent = (corners & (1<<i)) == 0;
            boolean rightPresent = (corners & (1<<((i + 1)%4))) == 0;
            if(leftPresent) needed--;
            if(rightPresent) needed--;
            if(needed < 0 || needed > n - 2) return false;
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