package striverCP.prime;
import java.util.*;
import java.io.*;
public class Q5 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        if(checkPrime(n)){
            out.println(1);
        }
        else{
            if(n %2 == 0 || checkPrime(n - 2)) out.println(2); // every even number is a sum of two prime number
            else out.println(3); // 3 + (n - 3) and n - 3 is an even number and sum of two primes numbers
        }

        out.close();
    }
    public static boolean checkPrime(int n) {
        if(n == 1) return false;
        int sqrt = (int)Math.sqrt(n);
        for(int i = 2; i<=sqrt; i++){
            if(n%i == 0) return false;
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