package striverCP.lazypropagation;

import java.util.*;
import java.io.*;

public class Q6 {
    static class Ring {
        int out, in, height;

        Ring(int i, int o, int h) {
            out = o;
            in = i;
            height = h;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d, %d)", in , out, height);
        }
    }
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int n = sc.nextInt();
        Set<Integer> set = new TreeSet<>();
        List<Ring> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt(), o = sc.nextInt(), h = sc.nextInt();
            list.add(new Ring(in, o, h));
            set.add(in);
            set.add(o);
        }

        List<Integer> intervals = new ArrayList<>(set);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<intervals.size(); i++){
            map.put(intervals.get(i), i);
        }

        out.println(map);
        LazySegmentTree lsg = new LazySegmentTree(intervals.size());
        
        list.sort((a, b) ->a.out == b.out ?b.in - a.in :b.out - a.out);

        out.println(list);

        long sum = 0;
        for(int i = 0; i<list.size(); i++){
            Ring ring = list.get(i);
            sum += ring.height;
            if(i == list.size() - 1 || list.get(i).out != list.get(i + 1).out){
                int left = map.get(ring.in), right = map.get(ring.out);
                out.printf("left = %d, right = %d, sum = %d\n", left, right, sum);
                lsg.update(left, right, sum);
                sum = 0;
            }
        }

        out.println(lsg.query());

        out.close();
    }

    static class LazySegmentTree {
        long seg[];
        long lazy[];
        int no_overlap_val = 0;
    
        LazySegmentTree(int n) {
            seg = new long[n * 4];
            lazy = new long[n * 4];
        }
    
        // function used while adding left and right intervals
        public long eval(long left, long right) {
            return Math.max(left, right);
        }
    
        // update the pending values whenever visiting the node
        public void updateLazy(int idx, int l, int r) {
            seg[idx] += lazy[idx];
            if (l != r) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0;
        }
    
        // update the range from l to r adding with value
        public void update(int l, int r, long value) {
            update(0, 0, seg.length / 4 - 1, l, r, value);
        }
    
        private void update(int idx, int low, int high, int l, int r, long val) {
    
            updateLazy(idx, low, high);
    
            // no overlap condition
            if (low > r || high < l) {
                return;
            }
            // complete overlap
            else if (l <= low && high <= r) {
                lazy[idx] += val;
                // updating here is important as we need the update value in the recursion
                updateLazy(idx, low, high);
                return;
            }
            // partial overlap
            else {
                int mid = low + (high - low) / 2;
                int left = 2 * idx + 1;
                int right = left + 1;
                update(left, low, mid, l, r, val);
                update(right, mid + 1, high, l, r, val);
                seg[idx] = eval(seg[left], seg[right]);
            }
        }
    
        public long query() {
            updateLazy(0, 0, seg.length/4 - 1);
            return seg[0];
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