package codeforces.sep1;

import java.util.*;
import java.io.*;

public class E {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            char[] str = sc.next().toCharArray();
            int even[] = new int[128], odd[] = new int[128], oldeven[] = new int[128], oldodd[] = new int[128];
            for (int i = 0; i < n; i += 2)
                even[str[i]]++;
            for (int i = 1; i < n; i += 2)
                odd[str[i]]++;
            if (n % 2 == 0) {
                int opers = minOpers(even) + minOpers(odd);
                out.println(opers);
            } else {
                int i = 0;
                int min = Integer.MAX_VALUE;
                for (char c : str) {

                    // removed
                    if (i % 2 == 0)
                        even[c]--;
                    else
                        odd[c]--;

                    min = Math.min(min,
                            1 + minOpers(add(oldeven, odd)) + minOpers(add(oldodd, even)));

                    if (i % 2 == 0)
                        oldeven[c]++;
                    else
                        oldodd[c]++;

                    i++;
                }

                out.println(min);
            }

        }

        out.close();
    }

    public static int[] add(int map1[], int map2[]) {
        int[] res = new int[map1.length];
        for (int i = 0; i < map1.length; i++) {
            res[i] = map1[i] + map2[i];
        }
        return res;
    }

    public static int minOpers(int map[]) {
        int max = Integer.MIN_VALUE, total = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (map[c] > 0) {
                max = Math.max(map[c], max);
                total += map[c];
            }
        }

        return total - max;
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
            int result[] = new int[n + 1];
            for (int i = 1; i <= n; i++)
                result[i] = nextInt();
            return result;
        }

        void sort(int arr[]) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                list.add(arr[i]);
            Collections.sort(list);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
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