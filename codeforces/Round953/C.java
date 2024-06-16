package codeforces.Round953;

import java.util.*;
import java.io.*;
public class C {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            int arr[] = new int[n];
            for(int i = 0; i< n ;i++) arr[i] = i + 1;
            int i = 0, j = n - 1;
            while(i < j && k >0){
                if(arr[j] - arr[i] <= k/2){
                    k-= 2L*(arr[j] - arr[i]);
                    swap(arr, j , i);
                    j--;
                    i++;
                }
                else{
                    j--;
                }
            }


            if(k == 0) {
                out.println("YES");
                for(int m = 0; m< n ;m++) out.print(arr[m] + " ");
                out.println();
            }
            else{
                out.println("NO");
            }
        }

        out.close();
    }
    public static void swap(int [] arr ,int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
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