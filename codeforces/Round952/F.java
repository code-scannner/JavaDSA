package codeforces.Round952;

import java.util.*;
import java.io.*;

public class F {
    static class Node{
        int idx;
        int attack;
        long time;
        Node(int i, int attk, long t){
            idx = i;
            attack = attk;
            time = t;
        }
    }
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int h = sc.nextInt(), n = sc.nextInt();
            int attacks[] = sc.narr(n);
            int cooldown[] = sc.narr(n);
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.time == b.time ? b.attack - a.attack : (int)(a.time - b.time));
            for (int i = 0; i < n; i++) {
                pq.offer(new Node (i, attacks[i], 0 ));
            }
            
            long time = 0;
            while (h > 0) {
                Node node = pq.poll();
                int idx = node.idx, attack = node.attack;
                long cool = node.time;
                time = cool;
                h -= attack;
                pq.offer(new Node(idx, attack, time + cooldown[idx] ));
            }
            out.println(time + 1);
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