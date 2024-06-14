package striverCP.stackqueue;
import java.util.*;
import java.io.*;
public class Q2 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        Stack<String> stk = new Stack<>();
        while (t-- > 0) {
            String str = sc.next();
            if(str.equals("pwd")){
                StringBuilder res = new StringBuilder();
                for(String s : stk){
                    res.append("/" + s);
                }
                res.append("/");
                out.println(res);
            }
            else{
                String[] val = sc.next().split("/");
                for(String op: val){
                    if(op.equals("")){
                        stk.clear();
                    }
                    else if(op.equals("..")){
                        if(!stk.isEmpty()) stk.pop();
                    }
                    else{
                        stk.push(op);
                    }
                }
            }
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