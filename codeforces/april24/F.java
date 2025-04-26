package codeforces.april24;

import java.util.*;
import java.io.*;

public class F {

    public static void main(String[] args) throws IOException, java.lang.Exception {

        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int length = sc.nextInt();
            String s = sc.next();

            boolean[] notOne = new boolean[length];
            for (int i = 0; i < length; i++)
                notOne[i] = s.charAt(i) == '0';

            int[] segment = new int[length];
            Arrays.fill(segment, -1);
            List<int[]> segments = new ArrayList<>();
            int cnt = 0;
            int j = 0;

            while (j < length) {
                if (!!notOne[j]) {
                    int start = j;
                    while (j < length && notOne[j]) {
                        segment[j] = cnt;
                        j++;
                    }
                    int end = j - 1;
                    segments.add(new int[] { start, end });
                    cnt++;
                } else {
                    j++;
                }
            }

            int total = cnt;
            long[] upper = new long[total];
            long[] lower = new long[total];
            int max = length - 1;

            for (int i = 0; i < total; i++) {
                int start = segments.get(i)[0];
                int end = segments.get(i)[1];
                int lseg = end - start + 1;
                long indSum = 0;
                if (start > 0) {
                    indSum = (1L * end * (end + 1) / 2) - (1L * (start - 1) * start / 2);
                } else {
                    indSum = 1L * end * (end + 1) / 2;
                }
                upper[i] = indSum;
                lower[i] = 1L * lseg * max - indSum;
            }

            int[] ids = new int[length];
            Arrays.fill(ids, -1);
            int dcnt = 0;
            for (int i = 0; i < length; i++) {
                if (s.charAt(i) == '1') {
                    ids[i] = dcnt++;
                }
            }

            int diagonals = dcnt;
            int nodes = 2 * total + diagonals;
            List<List<Integer>> graph = new ArrayList<>(nodes);
            for (int i = 0; i < nodes; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < length; i++) {
                int diagId = ids[i];
                if (diagId != -1) {
                    int nodeId = 2 * total + diagId;
                    if (i - 1 >= 0 && notOne[i - 1]) {
                        int segmentId = segment[i - 1];
                        graph.get(nodeId).add(total + segmentId);
                        graph.get(total + segmentId).add(nodeId);
                    }
                    if (i + 1 < length && notOne[i + 1]) {
                        int segmentId = segment[i + 1];
                        graph.get(nodeId).add(segmentId);
                        graph.get(segmentId).add(nodeId);
                    }
                }
            }

            boolean[] visited = new boolean[nodes];
            long ans = 0;

            for (int u = 0; u < nodes; u++) {
                if (!visited[u]) {
                    Stack<Integer> stack = new Stack<>();
                    stack.push(u);
                    visited[u] = true;
                    long sum = 0;

                    while (!stack.isEmpty()) {
                        int currentNode = stack.pop();
                        if (currentNode < total)
                            sum += upper[currentNode];
                        else if (2 * total > currentNode)
                            sum += lower[currentNode - total];
                        else {
                            sum += 1;
                        }

                        for (int neighbor : graph.get(currentNode)) {
                            if (!visited[neighbor]) {
                                visited[neighbor] = true;
                                stack.push(neighbor);
                            }
                        }
                    }
                    if (sum > ans) {
                        ans = sum;
                    }
                }
            }

            out.println(ans);
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
