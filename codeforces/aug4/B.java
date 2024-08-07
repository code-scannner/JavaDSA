package codeforces.aug4;

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
            long largestOdd = -1;
            Arrays.sort(arr);
            int evenCount = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 == 1) {
                    if (largestOdd < arr[i]) {
                        largestOdd = arr[i];
                    }
                } else {
                    evenCount++;
                }
            }
            
            if (evenCount == 0 || evenCount == n) {
                out.println(0);
            } else {
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (arr[i] % 2 == 0 && largestOdd > arr[i]) {
                        cnt++;
                        largestOdd += arr[i];
                        arr[i] = 1;
                    }
                }

                PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
                for (int i = 0; i < n; i++) {
                    if (arr[i] % 2 == 0)
                        pq.offer(arr[i]);
                }

                while (!pq.isEmpty()) {
                    if (pq.peek() < largestOdd) {
                        cnt++;
                        largestOdd += pq.poll();
                    } else {
                        cnt++;
                        largestOdd += pq.peek();
                    }
                }

                out.println(cnt);
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