package striverCP.tree;

import java.util.*;
import java.io.*;

public class Q3 {
    static int d = 0;
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i<=n ;i++) adj.add(new ArrayList<>());
        for(int i = 1; i<n; i++){
            int x= sc.nextInt(), y = sc.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        d = Math.max(d, diameter(adj, 1, 0));
        System.out.println(3*(d - 1));


        out.close();
    }

    public static int diameter(List<List<Integer>> adj, int node, int parent) {

        int max = 0, smax = 0;
        for(int next : adj.get(node)){
            if(next != parent){
                int val = diameter(adj, next, node);
                if(val > max){
                    smax = max; max = val;
                }
                else if(val > smax) smax = val;
            }
        }

        d = Math.max(d, 1 + max + smax);
        return 1 + max;

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