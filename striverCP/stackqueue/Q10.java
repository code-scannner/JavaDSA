package striverCP.stackqueue;

import java.util.*;
import java.io.*;

// some logic missing

public class Q10 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        Stack<Integer> stk = new Stack<>();
        int max = 0, globalmax = 0;
        boolean isPossible = true;
        while (n-- > 0) {
            int num = sc.nextInt();
            globalmax = Math.max(globalmax, num);
            if (!stk.empty() && stk.peek() == num) {
                if (max <= num) {
                    stk.pop();
                    max = num;
                } else {
                    isPossible = false;
                    break;
                }
            } else stk.push(num);
            if (stk.empty())
                max = 0;
        }

        if(stk.size() == 1 && stk.peek() < globalmax) isPossible = false;

        out.println(isPossible && stk.size() <= 1 ? "YES" : "NO");

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