package striverCP.dp;
import java.util.*;
import java.io.*;
public class Q22 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        List<Ring> list = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            int in = sc.nextInt(), o = sc.nextInt(), h = sc.nextInt();
            list.add(new Ring(o, in, h, i));
        }

        list.sort((a, b)->b.out == a.out ? b.in - a.in : b.out - a.out);
        
        Stack<Ring> stk = new Stack<>();
        long dp[] = new long[n];
        long max = -1;
        for(int i = 0;i <n; i++){
            Ring ring = list.get(i);
            while(!stk.isEmpty() && stk.peek().in >= ring.out) stk.pop();
            long prevHeight = stk.isEmpty() ? 0 : dp[stk.peek().ind];
            max = Math.max(max, ring.height + prevHeight);
            dp[ring.ind] = ring.height + prevHeight;
            stk.push(ring);
        }

        out.println(max);

        out.close();
    }

    static class Ring{
        int out, in, height, ind;
        Ring(int a, int b, int h, int index){
            out = a;
            in = b;
            height = h;
            ind = index;
        }
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