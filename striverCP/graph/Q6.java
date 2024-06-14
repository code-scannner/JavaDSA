package striverCP.graph;
import java.util.*;
import java.io.*;
public class Q6 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for(int i = 0; i< n; i++) list.add(sc.next());
        String res = isPossible(list);
        if(res.length() == 26){
            out.println(res);
        }
        else out.println("Impossible");

        out.close();
    }
    public static String isPossible(List<String> list){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i ='a'; i<='z';i++) adj.add(new ArrayList<>());
        for(int i = 1; i<list.size(); i++){
            char[] s1 = list.get(i - 1).toCharArray();
            char[] s2 = list.get(i).toCharArray();
            int j = 0;
            while(j < s1.length && j < s2.length && s1[j] == s2[j]) j++;
            if(j == s2.length && j < s1.length){
                return "";
            }
            else if(j < s1.length && j < s2.length) adj.get(s1[j] - 'a').add(s2[j] - 'a');
        }


        // topological sort
        int indegree[] = new int[26];
        for(int i = 0; i < 26; i++){
            for(int node : adj.get(i)) indegree[node]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i< 26; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        StringBuilder str = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            str.append((char)(node + 'a'));
            for(int next : adj.get(node)){
                if(--indegree[next] == 0) q.offer(next);
            }
        }
        return str.toString();
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