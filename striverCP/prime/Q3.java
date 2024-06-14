package striverCP.prime;
import java.util.*;
import java.io.*;

// there are approximately n/ln(n) primes less than equal to n

public class Q3 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        List<Integer> list = primes((int)1e8);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            out.println(list.get(sc.nextInt() - 1));
        }

        out.close();
    }
    public static List<Integer> primes(int n){
        List<Integer> list = new ArrayList<>();
        boolean seive[] = new boolean[n + 1];
        seive[0] = true;
        seive[1] = true;
        for (int i = 2; i <=n; i++) {
            if(!seive[i]){
                list.add(i);
                for (long j = (long)i*i; j <= n; j+=i) {
                    seive[(int)j] = true;
                }
            }            
        }

        return list;
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