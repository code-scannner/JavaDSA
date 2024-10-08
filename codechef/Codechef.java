package codechef;

import java.util.*;
import java.io.*;

class Codechef {

    public static void main(String[] args) throws IOException, java.lang.Exception {

        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt(), X = sc.nextInt(), K = sc.nextInt();
            int H[] = sc.narr(N);
            int cnt = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (K * X > H[i]) {
                    if (!set.contains(H[i])) {
                        cnt++;
                        set.add(H[i]);
                    }
                }
            }


            Arrays.sort(H);
            set.clear();
            boolean eaten[] = new boolean[N];

            int ate = 0;

            for(int i = N - 1; i>=0; i--){
                if(H[i] < X){
                    if(set.contains(H[i])){
                        X = H[i];
                        break;
                    }
                    eaten[i] = true;
                    ate++;
                    set.add(H[i]);
                }
            }

            for(int i = 0; i<N; i++){
                if(!eaten[i] && H[i] < K*X){
                    ate++;
                }
            }

            out.println(Math.max(cnt , ate));

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