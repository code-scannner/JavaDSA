package striverCP.prime;
import java.util.*;
import java.io.*;

// GOOD Question
public class Q4 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        int arr[] = sc.narr(n);
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            int number = num;

            // finding the max sequence yet with each prime factor as gcd
            int currMax = 0;
            for(int i = 2; (long)i*i <= number;i++){
                if(number % i == 0) currMax = Math.max(currMax, map.getOrDefault(i, 0));
                while(number > 1 && number%i == 0) number/=i;
            }
            if(number != 1) currMax = Math.max(currMax, map.getOrDefault(number, 0));
            
            
            // updating the global maximum with previous sequence + 1;
            currMax++;
            max = Math.max(currMax, max);
            
            
            // udpating each prime factor with new curr maximum sequence length;
            number = num;
            for(int i = 2; (long)i*i <= number;i++){
                if(number % i == 0) map.put(i, currMax);
                while(number > 1 && number%i == 0) number/=i;
            }
            if(number != 1) map.put(number, currMax);
        }

        out.println(max);

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