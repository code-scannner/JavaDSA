package codeforces.feb11;

import java.util.*;
import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = sc.narr(n);
            Arrays.sort(arr); // Using built-in sorting function

            Set<Integer> seen = new HashSet<>(); // To store numbers in the second bag

            for (int num : arr) {
                while (seen.contains(num)) num++; // Increment until it's unique
                seen.add(num); // Move to second bag
            }

            out.println(seen.size() == n ? "YES" : "NO");
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

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
