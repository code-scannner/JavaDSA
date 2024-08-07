package codechef;

import java.util.*;
import java.io.*;

class Codechef {

    public static void main(String[] args) throws IOException, java.lang.Exception {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();
            int back[] = new int[4];
            int front[] = new int[5];

            for(int i = n - 1; i>=0; i--){
                if(str.charAt(i) == 'k'){
                    back[3]++;
                }
                if(str.charAt(i) == 'c'){
                    if(back[3] > 0){
                        back[3]--;
                        back[2]++;
                    }
                }

                if(str.charAt(i) == 'a'){
                    if(back[2] > 0){
                        back[2]--;
                        back[1]++;
                    }
                }

                if(str.charAt(i) == 'b'){
                    if(back[1] > 0){
                        back[1]--;
                        back[0]++;
                    }
                }
            }

            for(int i = 0; i<n; i++){
                if(str.charAt(i) == 'f'){
                    front[0]++;
                }
                if(str.charAt(i) == 'r'){
                    if(front[0] > 0){
                        front[0]--;
                        front[1]++;
                    }
                }

                if(str.charAt(i) == 'o'){
                    if(front[1] > 0){
                        front[1]--;
                        front[2]++;
                    }
                }

                if(str.charAt(i) == 'n'){
                    if(front[2] > 0){
                        front[2]--;
                        front[3]++;
                    }
                }
                if(str.charAt(i) == 't'){
                    if(front[3] > 0){
                        front[3]--;
                        front[4]++;
                    }
                }
            }
            int avail = back[0];
            
            



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