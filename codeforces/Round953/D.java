package codeforces.Round953;
import java.util.*;
import java.io.*;
public class D {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(), c = sc.nextInt();
            int arr[] = sc.narr(n);
            arr[0] += c;
            int max = Arrays.stream(arr).max().getAsInt();
            int result[] = new int[n];

            Map<Integer, Integer> map = new HashMap<>();
            for(int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
            
            long [] prefixS = new long[n + 1];
            for(int i = 1; i<=n; i++) prefixS[i] = prefixS[i - 1] + arr[i - 1];

            for(int i = n - 1; i>=0; i--){
                int min = Integer.MAX_VALUE;
                map.put(arr[i], map.get(arr[i]) - 1);
                if(map.get(arr[i]) == 0) map.remove(arr[i]);
                
                boolean numberIsMax = arr[i] == max;
                boolean thereAreMoreMaximums = map.containsKey(max);
                if(numberIsMax && !thereAreMoreMaximums){
                    min = 0;
                }
                else{
                    long curr = prefixS[i + 1];
                    if(curr >= max) min = i;
                    else min = i + 1;
                }
                result[i] = min;
            }

            for (int i = 0; i < n; i++) {
                out.print(result[i] + " ");
            }
            out.println();
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