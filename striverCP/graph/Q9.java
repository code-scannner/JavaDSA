package striverCP.graph;
import java.util.*;
import java.io.*;
public class Q9 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt(), s = sc.nextInt();
        int type[] = new int[n + 1];
        for(int i = 1; i<=n; i++) type[i] = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i<m; i++) {
            int x =sc.nextInt(), y = sc.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        
        int cnt [] = new int[n + 1];
        boolean collected [][] = new boolean[n + 1][k + 1];
        int result [] = new int[n + 1];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            q.offer(new int[]{i, 0, type[i]});
            cnt[i]++;
            collected[i][type[i]] = true;
        }

        while (!q.isEmpty()) {
            int node [] = q.poll();
            int i = node[0], len = node[1], ty = node[2];
            if(cnt[i] >= s) continue;
            if(!collected[i][ty]){
                result[i] += len;
                cnt[i]++;
                collected[i][ty] = true;
            }

            for(int next : adj.get(i)){
                if(cnt[next] < s){
                    q.offer(new int[]{next, len + 1, ty});
                }
            }
        }

        for(int i = 1; i<=n; i++){
            out.print(result[i] + " ");
        }
        out.println();

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