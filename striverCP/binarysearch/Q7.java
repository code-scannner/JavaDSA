package striverCP.binarysearch;
import java.util.*;
import java.io.*;
public class Q7 {
    static int X [] = new int[100], Y[] = new int[100];
    static {
        X['L'] = -1; X['R'] = 1; Y['U'] = 1; Y['D'] = -1;
    }
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        char[] dirs = sc.next().toCharArray();
        int x = sc.nextInt(), y = sc.nextInt();

        int nx = 0, ny = 0;
        for(char c : dirs){
            nx += X[c];
            ny += Y[c];
        }

        int l = 0, r = n;
        while(l <= r){
            int m = (l + r)>>1;
            if(ans(m, dirs, x, y, nx, ny)){
                r = m - 1;
            }
            else l = m + 1;
        }

        if(l == n + 1) out.println(-1);
        else out.println(l);

        out.close();
    }
    public static boolean ans(int size, char[] dirs, int x, int y, int currx, int curry) {
        if(size == 0) return x == currx && y == curry;
        int i = 0;
        while(i < dirs.length){
            int c = dirs[i];
            currx -= X[c];
            curry -= Y[c];
            
            if(i >= size - 1){
                int manhattan = Math.abs(x - currx) + Math.abs(y - curry);
                if(manhattan <= size && (size - manhattan) % 2 == 0) return true;
            }

            i++;
            if(i >= size){
                int front = dirs[i - size];
                currx += X[front];
                curry += Y[front];
            }
        }

        return false;
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