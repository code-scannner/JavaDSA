package striverCP.graph;
import java.util.*;
import java.io.*;
public class Q8 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt();
        char[] rows = sc.next().toCharArray();
        char[] cols = sc.next().toCharArray();
        
        out.println(isPossible(rows, cols, n, m) ? "YES" : "NO");
        
        out.close();
    }
    public static boolean isPossible(char[] rows, char[] cols, int n, int m){
        for(int i = 0;i <n; i++){
            for(int j = 0; j<m;j++){
                boolean visited[][] = new boolean[n][m];
                visited[i][j] = true;
                if(countVisited(visited, i, j, rows, cols) !=  n*m){
                    return false;
                }
            }
        }
        return true;
    }
    public static int countVisited(boolean visited[][], int i, int j, char rows[], char cols[]){
        int nextj = rows[i] == '>' ? j + 1 : j - 1;
        int nexti = cols[j] == '^' ? i - 1 : i + 1;
        int cnt = 1;
        if(nextj < cols.length && nextj >= 0 && !visited[i][nextj]){
            visited[i][nextj] = true;
            cnt += countVisited(visited, i, nextj, rows, cols);
        }
        if(nexti < rows.length && nexti >= 0 && !visited[nexti][j]){
            visited[nexti][j] = true;
            cnt += countVisited(visited, nexti, j, rows, cols);
        }
        return cnt;
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