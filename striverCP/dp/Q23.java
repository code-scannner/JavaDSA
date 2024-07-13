package striverCP.dp;
import java.util.*;
import java.io.*;
public class Q23 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int indegree[] = new int[n + 1];
        int outdegree[] = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        for(int i = 0; i<=n; i++) {
            adj.add(new ArrayList<>());
            adj2.add(new ArrayList<>());
        }

        for(int i = 1; i<n; i++){
            int x = sc.nextInt(), y = sc.nextInt();
            adj.get(x).add(y);
            adj2.get(y).add(x);
            outdegree[x]++;
            indegree[y]++;
        }

        int dp[] = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(int next : adj.get(node)){
                dp[next] += dp[node] + 1;
                if(--indegree[next] == 0) q.offer(next);
            }
        }

        for(int i = 1; i<=n; i++){
            if(outdegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for(int next : adj2.get(node)){
                dp[next] = dp[node] - 1;
                if(--outdegree[next] == 0) q.offer(next);
            }
        }

        dp[0] = Integer.MAX_VALUE;
        int min = Arrays.stream(dp).min().getAsInt();
        out.println(min);
        for(int i = 1; i<=n; i++){
            if(dp[i] == min) out.print(i + " ");
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