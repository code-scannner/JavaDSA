package striverCP.implement;

import java.util.*;
import java.io.*;

public class Q42 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        char [] str = sc.next().toCharArray();
        int left = 0, right = 0;
        boolean isPossible = false;
        for(int i = 0; i<n ;i++){
            int map[] = new int[127];
            int max = 0;
            for(int j = i;j <n; j++){
                max = Math.max(max , ++map[str[j]]);
                if(max <= (j - i + 1)/2){
                    isPossible = true;
                    left = i;
                    right = j;
                    break;
                }
            }
            if(isPossible) break;
        }
        if(isPossible){
            out.println("YES");
            for(int i = left; i <= right; i++){
                out.print(str[i]);
            }
            out.println();
        }
        else{
            out.println("NO");
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