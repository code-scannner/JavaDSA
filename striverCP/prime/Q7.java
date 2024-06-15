package striverCP.prime;
import java.util.*;
import java.io.*;
public class Q7 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), m = sc.nextInt();
        Map<Integer, Integer> numerator = new HashMap<>();
        Map<Integer, Integer> denominator = new HashMap<>();

        for(int i = 0;i <n; i++){
            add(numerator, sc.nextInt());
        }
        for(int i = 0;i <m; i++){
            add(denominator, sc.nextInt());
        }

        for(int key : numerator.keySet()){
            if(denominator.containsKey(key)){
                int dval = denominator.get(key);
                int nval = numerator.get(key);
                if(dval > nval){
                    denominator.put(key, dval - nval);
                    numerator.remove(key);
                }
                else if(dval == nval){
                    numerator.remove(key);
                    denominator.remove(key);
                }
                else{
                    numerator.put(key, nval - dval);
                    denominator.remove(key);
                }
            }
        }

        out.println((numerator.size() + 1) + " " + (denominator.size() + 1));
        out.print(1);
        for(int key : numerator.keySet()){
            out.print(" " + key*numerator.get(key));
        }

        out.close();
    }

    public static void add(Map<Integer, Integer> map, int n) {
        for(int i = 2; (long)i *i <= n; i++){
            int cnt = 0;
            while(n%i == 0) {
                n/=i;
                cnt++;
            }
            map.put(i, map.getOrDefault(i, 0) + cnt);
        }
        
        if(n != 1) map.put(n, map.getOrDefault(n, 0) + 1);
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