package strings;
import java.util.*;

public class PrefixAlsoSuffix {
    public static int longestPrefixSuffix(String str) {
        int[] A = new int[str.length()];
        int j = 0, i = 1;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                A[i] = j + 1;
                j++;
                i++;
            } else {
                if (j == 0)
                    i++;
                else
                    j = A[j - 1];

            }
        }

        System.out.println(Arrays.toString(A));

        return A[str.length() - 1];
    }

    public static void main(String[] args) {
        String str = "bbabbabb";
        System.out.println(longestPrefixSuffix(str));
    }
}
