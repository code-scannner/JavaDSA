package codeforces.july11;

import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int digits = countdigits(n);
            StringBuilder s = new StringBuilder();
            List<int[]> list = new ArrayList<>();
            for(int i = 1; i<=6; i++){
                s.append(n);
            }
            for(int i = 1; i<=s.length(); i++){
                String str = s.substring(0, i);
                int num = Integer.parseInt(str.toString());
                if(num > (int)1e6) break;
                for(int a = 1; a <= 10000; a++){
                    int b = a*n - num;
                    if(b > 0 && b < 10000 && a*digits - b == countdigits(num)){
                        list.add(new int[]{a, b});
                    }
                }
            }

            out.println(list.size());
            for(int arr[] : list){
                out.println(arr[0] + " " + arr[1]);
            }
        }

        out.close();
    }

    static int countdigits(int num){
        return (int)(Math.log(num)/Math.log(10)) + 1;
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