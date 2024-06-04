package striverCP.tree;

import java.util.*;
import java.io.*;

// tags = topological sort

public class Q1 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int subs[] = new int[n + 1];
        int outdegree[] = new int[n + 1];
        int parent[] = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int p = sc.nextInt();
            parent[i] = p;
            outdegree[p]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=n ;i++) 
            if(outdegree[i] == 0)
                q.offer(i);
        
        while(!q.isEmpty()){
            int child = q.poll();
            int p = parent[child];
            subs[p] += 1 + subs[child];
            // if this is a leaf node
            if(--outdegree[p] == 0){
                q.offer(p);
            }
        }

        for (int i = 1; i <= n; i++) {
            out.print(subs[i] + " ");
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