package leetcode;

public class leet_2147 {
    public static int numberOfWays(String s) {
        long result = 1;
        int peas = 1, n = s.length(), i = 0, mod = (int) 1e9 + 7;
        while (i < n) {
            result = (result * peas) % (mod);
            int c = 0;
            while (i < n && c < 2) {
                if (s.charAt(i) == 'S')
                    c++;
                i++;
            }
            if (c != 2)
                return 0;
            peas = 1;
            while (i < n && s.charAt(i) == 'P') {
                i++;
                peas++;
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        String str = "PPSPSPSSPPSPSPPPSS";
        System.out.println(numberOfWays(str));
    }
}
