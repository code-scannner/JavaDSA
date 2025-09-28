package tree;
import java.util.*;
import java.io.*;

public class TreeDistanceI {

    public static void main(String[] args) throws IOException {

        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();

        int n = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int i = 1; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int ans[] = new int[n + 1];
        int depth[] = new int[n + 1];

        calculateDepth(adj, 1, -1, depth);

        solve(adj, 1, -1, 0, ans, depth);

        for(int i = 1; i<=n; i++){
            out.print(ans[i] + " ");
        }

        out.close();

    }

    public static void solve(List<List<Integer>> adj, int node, int parent, int parentLength, int ans[], int depth[]) {
        // if(node == 3){
        //     System.out.println("Parent length is " + parentLength);
        // }
        if (adj.get(node).size() == 1 && adj.get(node).get(0) == parent) {
            ans[node] = parentLength;
            return;
        }

        ans[node] = Math.max(depth[node], parentLength);

        List<Integer> childDepths = new ArrayList<>();
        for (int next : adj.get(node)) {
            if (next != parent) {
                childDepths.add(1 + depth[next]);
            }
        }

        MidMax midmax = new MidMax(childDepths);
        int i = 0;
        for (int next : adj.get(node)) {
            if (next != parent) {
                solve(adj, next, node, 1 + Math.max(parentLength, midmax.getMaxExcept(i)), ans, depth);
                i++;
            }
        }
    }

    static class MidMax {
        int prefixmax[], suffixmax[];

        MidMax(List<Integer> arr) {
            int n = arr.size();
            prefixmax = new int[n + 1];
            suffixmax = new int[n + 1];
            for (int i = 0; i < n; i++) {
                prefixmax[i + 1] = Math.max(prefixmax[i], arr.get(i));
            }
            for (int i = n - 1; i >= 0; i--) {
                suffixmax[i] = Math.max(suffixmax[i + 1], arr.get(i));
            }
        }

        int getMaxExcept(int i) {
            return Math.max(prefixmax[i], suffixmax[i + 1]);
        }
    }

    public static int calculateDepth(List<List<Integer>> adj, int node, int parent, int depth[]) {
        if (adj.get(node).size() == 1 && adj.get(node).get(0) == parent) {
            depth[node] = 0;
            return 0;
        }
        int maxDepth = 0;
        for (int next : adj.get(node)) {
            if (next == parent)
                continue;
            maxDepth = Math.max(maxDepth, 1 + calculateDepth(adj, next, node, depth));
        }

        return depth[node] = maxDepth;
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

        void sort(int arr[]) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                list.add(arr[i]);
            Collections.sort(list);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
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