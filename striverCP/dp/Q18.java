package striverCP.dp;
import java.util.*;
import java.io.*;
public class Q18 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        long l = sc.nextLong();
        long r = sc.nextLong();
        out.println(count(Long.toString(r)) - count(Long.toString(l - 1)));
        out.close();
    }
    public static long count(String n) {
        int d = n.length();
        if(d == 1) return n.charAt(0) - '0';
        int [] num = new int[d];
        for(int i = 0; i<d;i++) num[i] = n.charAt(i) - '0';
        long res = (long)Math.pow(10, d - 2) + 8;
        if(num[0] >= num[d - 1]){
            res += (long)(num[0] - 1)*(long)Math.pow(10, d - 2);
        }
        else {
            res += (long)(num[0])*(long)Math.pow(10, d - 2);
        }

        if(num[0] == num[d - 1]){
            res++;
            if(d != 2){
                res += Long.parseLong(n.substring(1, d - 1));
            }
        }

        return res;

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