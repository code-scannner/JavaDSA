package codeforces.july7;
import java.util.*;
import java.io.*;
public class B {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int a[][] = new int[n][m];
            int b[][] = new int[n][m];

            for(int i = 0; i<n; i++){
                char c [] =  sc.next().toCharArray();
                for(int j = 0; j<m; j++) a[i][j] = c[j] - '0';
            }
            for(int i = 0; i<n; i++){
                char c [] =  sc.next().toCharArray();
                for(int j = 0; j<m; j++) b[i][j] = c[j] - '0';
            }

            boolean isPossible = true;
            for(int i = n - 1; i>= 1; i--){
                for(int j = m - 1; j>= 1; j--){
                    if(a[i][j] == b[i][j]) continue;
                    int ai = a[i][j], bi = b[i][j];
                    if((ai + 1)%3 == bi){
                        a[i - 1][j - 1] = (a[i - 1][j - 1] + 1)%3;
                        a[i][j - 1] = (a[i][j - 1] + 2)%3;
                        a[i - 1][j] = (a[i - 1][j] + 2)%3;
                    }
                    else{
                        a[i - 1][j - 1] = (a[i - 1][j - 1] + 2)%3;
                        a[i][j - 1] = (a[i][j - 1] + 1)%3;
                        a[i - 1][j] = (a[i - 1][j] + 1)%3;
                    }
                }
            }

            for(int i = 0; i<n; i++){
                if(a[i][0] != b[i][0])  {
                    isPossible = false;
                    break;
                }
            }
            for(int i = 0; i<m; i++){
                if(a[0][i] != b[0][i])  {
                    isPossible = false;
                    break;
                }
            }

            out.println(isPossible ? "YES" : "NO");


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