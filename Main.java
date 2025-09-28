import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt(), q = sc.nextInt();
        int arr[] = sc.narr(n);
        int queries[][] = new int[q][3];
        for (int query[] : queries) {
            if (sc.nextChar() == '!') {
                query[0] = 1;
            } else {
                query[0] = 2;
            }
            query[1] = sc.nextInt();
            query[2] = sc.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int item : arr)
            set.add(item);
        for (int[] query : queries) {
            if (query[0] == 1)
                set.add(query[2]);
        }

        int salaries[] = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        for (int i = 0; i < salaries.length; i++) {
            salaries[i] = iter.next();
        }

        Map<Integer, Integer> salaryToIndex = new HashMap<>();
        for (int i = 0; i < salaries.length; i++) {
            salaryToIndex.put(salaries[i], i);
        }

        int count[] = new int[salaries.length];
        for (int item : arr) {
            int idx = salaryToIndex.get(item);
            count[idx]++;
        }

        BinaryIndexedTree bit = new BinaryIndexedTree(count);

        for (int[] query : queries) {
            if (query[0] == 1) {
                int k = query[1] - 1;
                int x = query[2];
                int prevIdx = salaryToIndex.get(arr[k]);
                int newIdx = salaryToIndex.get(x);
                arr[k] = x;
                bit.add(prevIdx, -1);
                bit.add(newIdx, 1);
            } else {
                Integer a = query[1], b = query[2];
                a = set.ceiling(a);
                b = set.floor(b);
                if (a == null || b == null) {
                    out.println(0);
                    continue;
                }
                int l = salaryToIndex.get(a), r = salaryToIndex.get(b);
                out.println(bit.sum(l, r));
            }
        }

        out.close();
    }

    // Fenwick Tree (Binary Indexed Tree) for Range Query + Point Update
    static class BinaryIndexedTree {
        // 1-indexed internal tree
        int[] bit;

        // Build from array in O(n)
        public BinaryIndexedTree(int[] arr) {
            int n = arr.length;
            bit = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                bit[i] += arr[i - 1];
                int parent = i + (i & -i); // move to next segment
                if (parent <= n) {
                    bit[parent] += bit[i];
                }
            }
        }

        // Empty BIT of given size
        public BinaryIndexedTree(int n) {
            bit = new int[n + 1];
        }

        // Add 'val' to index i (0-based index)
        public void add(int i, int val) {
            i++; // convert to 1-based
            while (i < bit.length) {
                bit[i] += val;
                i += i & -i; // move to next segment
            }
        }

        // Prefix sum from 0 to i (0-based index)
        public int sum(int i) {
            i++; // convert to 1-based
            int s = 0;
            while (i > 0) {
                s += bit[i];
                i -= i & -i; // move to previous segment
            }
            return s;
        }

        // Range sum from l to r inclusive (0-based indices)
        public int sum(int l, int r) {
            if (l > r)
                return 0; // safety
            return sum(r) - (l > 0 ? sum(l - 1) : 0);
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

        void printArr(int arr[], PrintWriter out) {
            for (int i = 0; i < arr.length; i++) {
                if (i != 0)
                    out.print(" ");
                out.print(arr[i]);
            }
            out.println();
        }

        int[] narr(int n) throws IOException {
            int result[] = new int[n];
            for (int i = 0; i < n; i++)
                result[i] = nextInt();
            return result;
        }

        char nextChar() throws IOException {
            return next().charAt(0);
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