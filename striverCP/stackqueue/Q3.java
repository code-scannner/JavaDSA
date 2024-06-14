package striverCP.stackqueue;

import java.util.*;
import java.io.*;

// DP + Stack

public class Q3 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        char[] str = sc.next().toCharArray();
        Stack<Integer> stk = new Stack<>();
        int dp[] = new int[str.length + 1];
        int max = 0, count = 1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ')') {
                if (!stk.isEmpty()) {
                    int openBracket = stk.pop();
                    int len = i - openBracket + 1 + dp[openBracket];
                    if(len > max){
                        max = len;
                        count = 1;
                    }
                    else if(len == max) count++;
                    dp[i + 1] = len;
                }
            } else {
                stk.push(i);
            }
        }

        out.println(max + " " + count);

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