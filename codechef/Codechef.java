// First Subsequence Google ✅
package codechef;

import java.util.Scanner;

public class Codechef {

    public static boolean isSubsequenceWithOneChange(String A, String B, int s) {
        int m = B.length();
        int n = A.length();
        int j = 1; // Start comparing from the second character of B
        int c = 0; // Track the number of changes made

        for (int i = s + 1; i < n && j < m; ++i) {
            if (A.charAt(i) == B.charAt(j)) {
                j++;
            } else if (c == 0) {
                c++;
                j++;
            }
        }

        return j == m || (j == m - 1 && c == 0);
    }

    public static int firstOccurrence(String A, String B) {
        int m = B.length();
        int n = A.length();

        for (int i = 0; i <= n - m; ++i) {
            if (A.charAt(i) == B.charAt(0) && isSubsequenceWithOneChange(A, B, i)) {
                return i + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int t = 0; t < T; ++t) {
            String A = sc.nextLine();
            String B = sc.nextLine();
            System.out.println(firstOccurrence(A, B));
        }

        sc.close();
    }
}