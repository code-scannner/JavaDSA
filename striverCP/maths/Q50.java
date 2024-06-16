package striverCP.maths;
import java.util.*;
import java.io.*;
public class Q50 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            long a1 = sc.nextLong(), k = sc.nextLong();
            long term = a1;
            for(int i = 1; i<k ;i++){
                int add = minDigit(term)*maxDigit(term);
                if(add == 0) break;
                term = term + minDigit(term)*maxDigit(term);
            }
            out.println(term);
        }

        out.close();
    }
    public static int minDigit(long n) {
        int min = Integer.MAX_VALUE;
        while(n> 0){
            min = Math.min(min, (int)(n%10));
            n/=10;
        }
        return min;
    }
    public static int maxDigit(long n) {
        int max = Integer.MIN_VALUE;
        while(n> 0){
            max = Math.max(max, (int)(n%10));
            n/=10;
        }
        return max;
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