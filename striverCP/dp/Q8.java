package striverCP.dp;
import java.util.*;
import java.io.*;
public class Q8 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), k = sc.nextInt();
        int theorems[] = sc.narr(n);
        int sleep[] = sc.narr(n);
        int total [] = new int[n + 1];
        int sleepSum[] = new int[n + 1];
        for(int i = 0 ;i<n; i++){
            total[i + 1] = total[i] + theorems[i];
            sleepSum[i + 1] += sleepSum[i] + (sleep[i] == 1 ? theorems[i] : 0);
        }
        int maxLectures = 0;
        for(int i = 0; i<n; i++){
            int end = Math.min(n, i + k);
            int curr = sleepSum[i] + total[end] - total[i] + sleepSum[n] - sleepSum[end];
            maxLectures = Math.max(maxLectures, curr);
        }
        out.println(maxLectures);

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