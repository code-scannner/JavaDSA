package striverCP.prime;

import java.util.*;
import java.io.*;


public class Q7 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt();
        int a[] = sc.narr(n);
        int b[] = sc.narr(m);
        List<Integer> numer = new ArrayList<>(), denom = new ArrayList<>();
        int i = 0, j = 0;
        while(i < a.length && j < b.length){
            int gcd = hcf(a[i], b[j]);
            numer.add(a[i++]/ gcd);
            denom.add(b[j++]/ gcd);
        }

        while(i < a.length){
            numer.add(a[i++]);
            denom.add(1);
        }
        while(j < b.length){
            numer.add(1);
            denom.add(b[j++]);
        }

        out.println(numer.size() + " " + denom.size());

        for(int k = 0;k <numer.size(); k++){
            out.print(numer.get(k) + " ");
        }

        out.println();

        for(int k = 0; k<denom.size(); k++){
            out.print(denom.get(k) + " ");
        }

        out.println();

        out.close();
    }
    public static int hcf(int d, int rem) {
        if (rem == 0)
            return d;
        return hcf(rem, d % rem);
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